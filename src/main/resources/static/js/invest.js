document.getElementById("investmentDropdown").addEventListener("change", function () {
    const selectedValue = this.value;
    const detailsContainer = document.getElementById("investmentDetails");
    let details = "";

    switch (selectedValue) {
        case "5":
            details = "<strong>5% Purchase:</strong> Invest $200,000 for a 5% stake in NeuroWave.";
            break;
        case "2":
            details = "<strong>2% Purchase:</strong> Invest $105,000 for a 2% stake in NeuroWave.";
            break;
        case "1":
            details = "<strong>1% Purchase:</strong> Invest $65,000 for a 1% stake in NeuroWave.";
            break;
        case "donation":
            details = `
                <strong>Donation Perks:</strong> 
                Donate $500 or more to receive lifetime access to our digital offerings and discounted rates on services!
            `;
            break;
        default:
            details = "Please select an investment option.";
    }

    detailsContainer.innerHTML = details;
    detailsContainer.style.display = "block";
});