import { apiInstance } from "./index.js";

const api = apiInstance();

function joinMember(user, success, fail) {
  api.post(`/user/join`, JSON.stringify(user)).then(success).catch(fail);
}

async function idCheck(userid, success, fail) {
  await api.get(`/user/idcheck/${userid}`).then(success).catch(fail);
}

export { joinMember, idCheck };
