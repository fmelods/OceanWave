window.watsonAssistantChatOptions = {
  integrationID: "eca352a0-5c41-4010-806c-f66d5fc76382", // The ID of this integration.
  region: "au-syd", // The region your integration is hosted in.
  serviceInstanceID: "7ef392b2-493d-4576-afad-7e83c149fdbd", // The ID of your service instance.
  onLoad: async (instance) => {
    await instance.render();
  },
};
setTimeout(function () {
  const t = document.createElement("script");
  t.src =
    "https://web-chat.global.assistant.watson.appdomain.cloud/versions/" +
    (window.watsonAssistantChatOptions.clientVersion || "latest") +
    "/WatsonAssistantChatEntry.js";
  document.head.appendChild(t);
});
