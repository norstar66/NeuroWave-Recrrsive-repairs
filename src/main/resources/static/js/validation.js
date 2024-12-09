document.getElementById("signupForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent form submission

    // Get the email input value
    const email = document.getElementById("email").value;
    const emailError = document.getElementById("emailError");

    // Email validation RegEx
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!emailRegex.test(email)) {
        emailError.style.display = "inline";
    } else {
        emailError.style.display = "none";

        // Form submission logic (redirect or AJAX)
        alert("Form submitted successfully!");
        // Uncomment the next line to allow form submission
        // event.target.submit();
    }
});

