document.addEventListener('DOMContentLoaded', function() {
    function sessionDropdown() {
        const dropdown = document.getElementById("dropdown-menu");
        if (dropdown) {
            dropdown.classList.toggle("show");
        }
    }

    window.onclick = function(event) {
        if (!event.target.matches('#session-button')) {
            const dropdown = document.getElementById("dropdown-menu");
            if (dropdown && dropdown.classList.contains("show")) {
                dropdown.classList.remove("show");
            }
        }
    }

 
    const sessionButton = document.getElementById('session-button');
    if (sessionButton) {
        sessionButton.addEventListener('click', sessionDropdown);
    }
});

