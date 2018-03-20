const xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
	if(xhr.readyState === 4 && xhr.status===200) {
		const res = JSON.parse(xhr.responseText)
		const body = document.body
		const productContainer = document.createElement('div')
		productContainer.innerText = res.name

		body.appendChild(productContainer)
	}
}
xhr.open('GET', '/products/1000', true)
xhr.send()