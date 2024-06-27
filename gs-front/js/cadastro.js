document.addEventListener("DOMContentLoaded", (event) => {
  const form = document.getElementById("projectForm");
  const message = document.getElementById("message");
  const submitBtn = document.getElementById("submit-btn");

  submitBtn.addEventListener("click", function (event) {
    event.preventDefault();
    message.textContent = ""; // Clear any previous messages

    const name = form.name.value.trim();
    const ong = form.ong.value.trim();
    const email = form.email.value.trim();
    const details = form.details.value.trim();

    if (!name || !ong || !email || !details) {
      message.textContent = "Por favor, preencha todos os campos.";
      return;
    }

    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
      message.textContent = "Por favor, insira um email válido.";
      return;
    }

    message.textContent = "Cadastro enviado com sucesso!";
    message.style.color = "green";
  });
});
