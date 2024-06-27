document.addEventListener("DOMContentLoaded", (event) => {
    const heroTitle = document.getElementById("hero-title");
  
    heroTitle.addEventListener("mouseover", () => {
      heroTitle.style.transform = "scale(1.1)";
      heroTitle.style.transition = "transform 0.3s, text-shadow 0.3s";
      heroTitle.style.textShadow = "5px 5px 10px rgba(0, 0, 0, 0.9)";
    });
  
    heroTitle.addEventListener("mouseout", () => {
      heroTitle.style.transform = "scale(1)";
      heroTitle.style.textShadow = "3px 3px 6px rgba(0, 0, 0, 0.7)";
    });
  });