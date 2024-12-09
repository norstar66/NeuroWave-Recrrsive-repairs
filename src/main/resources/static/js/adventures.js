


async function getUserCodespaceUrl() {
    try {
        const response = await fetch('/auth/github/codespaces', {
            method: 'GET',
        });

        if (!response.ok) {throw new Error('Failed to fetch Codespaces');
        }

        const codespaces = await response.json();
        return codespaces[0]?.web_url || null; // Return the first Codespace URL
    } catch (error) {
        console.error('Error fetching Codespaces:', error);
        return null;
    }
}

