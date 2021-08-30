const name = document.getElementById('name')
const email = document.getElementById('email')
const pass = document.getElementById('pass')
const form = document.getElementById('register')

form.addEventListener('submit',(e) => {
    let msg = []
    if(name.value === '' || name.value == null){
        msg.push("Name is required")
    }
    if(pass.value.length <= 6){
        msg.push('Password mustbe longer than 6 characters')
    }

})