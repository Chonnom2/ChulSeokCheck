<template>
  <v-form ref="form" v-model="valid">
    <v-text-field
      v-model="id"
      :counter="10"
      :rules="rules.idRule"
      :error-messages="id_dup"
      label="아이디"
      required
    ></v-text-field>

    <v-text-field
      v-model="pwd"
      type="password"
      label="비밀번호"
      required
      :rules="[rules.pwdRule[0]]"
    ></v-text-field>

    <v-text-field
      v-model="pwdChk"
      type="password"
      label="비밀번호 확인"
      :rules="rules.pwdRule"
      required
    ></v-text-field>

    <v-text-field
      v-model="name"
      :counter="8"
      :rules="rules.nameRule"
      label="이름"
      required
    ></v-text-field>

    <v-text-field v-model="email" :rules="rules.emailRule" label="E-mail" required> </v-text-field>

    <v-checkbox
      v-model="checkbox"
      :rules="[(v) => !!v || '안할거면 가입 왜함?!!']"
      label="공부 똑띠 할꺼?"
      required
    ></v-checkbox>

    <v-btn :disabled="!valid" color="success" class="mr-2" @click="join"> 가입하기 </v-btn>
    <v-btn color="error" @click="$router.push({ name: 'main' }).catch(() => {})"> 취소 </v-btn>
  </v-form>
</template>

<script>
import { idCheck, joinMember } from "@/api/member";

export default {
  name: "MemberJoin",
  components: {},
  data() {
    return {
      name: "",
      email: "",
      id: "",
      pwd: "",
      pwdChk: "",
      checkbox: false,
      id_dup: [],
      valid: false,
      rules: {
        idRule: [(v) => v.length >= 5 || "5자 이상 입력해주세요", (v) => this.idChecking(v)],
        nameRule: [
          (v) => !!v || "이름을 입력해주세요",
          (v) => (v && v.length <= 8) || "8글자까지 입력해주세요",
        ],
        pwdRule: [
          (v) => v.length >= 4 || "최소 4글자 입력해주세요.",
          () => this.pwd === this.pwdChk || "비밀번호를 확인해주세요.",
        ],
        emailRule: [
          (v) => !!v || "E-mail을 입력해주세요",
          (v) => /.+@.+\..+/.test(v) || "E-mail 형식을 맞춰주세요.",
        ],
      },
    };
  },
  created() {},
  methods: {
    async idChecking(userId) {
      console.log(userId, "체크");
      await idCheck(
        userId,
        ({ data }) => {
          console.log(data);
          if (data.code == 1001) {
            // 사용가능한 아이디인 경우
            this.id_dup = [];
          } else {
            this.id_dup = ["아이디가 중복됩니다."];
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
    join() {
      let member = {
        userId: this.id,
        userPwd: this.pwd,
        userEmail: this.email,
        userName: this.name,
      };
      joinMember(
        member,
        ({ data }) => {
          console.log(data);
          if (data.code == 1000) {
            alert("회원가입 성공!");
            this.$router.push({ name: "main" });
          } else {
            alert("회원가입에 실패하였습니다. 다시 시도해주세요.");
          }
        },
        (error) => {
          console.log(error);
          alert("회원가입에 실패하였습니다. 다시 시도해주세요.");
        }
      );
    },
  },
};
</script>

<style scoped></style>
