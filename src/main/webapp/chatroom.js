var CreateProxy = function(wsUri, name) {
    var websocket = null;
    var elements = null;

    var showMsgPanel = function() {
        // elements.loginPanel.style.display = "none";
        elements.msgPanel.style.display = "block";
        elements.txtMsg.focus();
    };

    var displayMessage = function(msg) {
        if (elements.msgContainer.childNodes.length == 100) {
            elements.msgContainer.removeChild(elements.msgContainer.childNodes[0]);
        }

        var div = document.createElement('div');
        div.className = 'msgrow';
        var textnode = document.createTextNode(msg);
        div.appendChild(textnode);
        elements.msgContainer.appendChild(div);

        elements.msgContainer.scrollTop = elements.msgContainer.scrollHeight;
    };

    return {
        sendMessage: function() {
            elements.txtMsg.focus();

            if (websocket != null && websocket.readyState == 1) {
                var input = elements.txtMsg.value.trim();
                if (input == '') { return; }

                elements.txtMsg.value = '';

                var message = { messageType: 'MESSAGE', message: input };

                // Send a message through the web-socket
                websocket.send(JSON.stringify(message));
            }
        },
        login_keyup: function(e) { if (e.keyCode == 13) { this.login(); } },
        sendMessage_keyup: function(e) { if (e.keyCode == 13) { this.sendMessage(); } },
        logout: function() {
            if (websocket != null && websocket.readyState == 1) { websocket.close();}
        },
        initiate: function(e) {
            elements = e;

            if (websocket == null) {
                websocket = new WebSocket(wsUri);

                websocket.onopen = function() {
                    var message = { messageType: 'LOGIN', message: name };
                    websocket.send(JSON.stringify(message));
                };
                websocket.onmessage = function(e) {
                    displayMessage(e.data);
                    showMsgPanel();
                };
                websocket.onerror = function(e) {};
                websocket.onclose = function(e) {
                    websocket = null;
                };
            }
        }
    }
};