var ws;

function connect() {
    var username = document.getElementById("usernamee").value;

    var host = document.location.host;
    var pathname = document.location.pathname.split("/")[1];
    console.log("ws://" + host+"/" + pathname + "/chat/" + username)
    console.log("ws://" + host + pathname + "/chat/" + username)
    ws = new WebSocket("ws://" + host+"/" + pathname + "/chat/" + username);

    ws.onmessage = function(event) {
        var message = JSON.parse(event.data);
        if (message.content === "Connected!" || message.content === "Disconnected!"){
            var log = document.getElementById("peopleConnect");
            log.innerHTML += message.from + " : " + message.content + "\n";
        }else{
            var log = document.getElementById("log");
            log.innerHTML += message.from + " : " + message.content + "\n";
        }
    };

}

function send() {
    var content = document.getElementById("msgg").value;
    var json = JSON.stringify({
        "content": content
    });

    ws.send(json);
}