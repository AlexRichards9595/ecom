const xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
	if(xhr.readyState === 4 && xhr.status===200) {
		const res = JSON.parse(xhr.responseText)
		const productsContainer = document.querySelector('#products-container')
		
		for (product in res) {
			const productContainer = document.createElement('div')
			const productLink = document.createElement('a')
			productLink.setAttribute('href', '/product.html')
			productContainer.innerText = res[product].name
			productContainer.appendChild(productLink)
			productsContainer.appendChild(productContainer)
		}

	}
}
xhr.open('GET', '/products', true)
xhr.send()