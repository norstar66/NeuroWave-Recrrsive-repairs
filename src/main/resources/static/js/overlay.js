
// Add event listeners to all header and footer links
document.querySelectorAll("header a, footer a").forEach(link => {
    link.addEventListener("click", event => {
        event.preventDefault(); // Prevent default navigation
        const targetUrl = event.target.href; // Get the target URL

        // Show overlay with animation
        const loadingOverlay = document.getElementById("loadingOverlay");
        loadingOverlay.style.display = "flex";

        setTimeout(() => {
            // Redirect to the target page after the animation
            window.location.href = targetUrl;
        }, 2000); // Match your animation duration
    });
});

