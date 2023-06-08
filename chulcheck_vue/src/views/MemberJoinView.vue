<template>
  <v-container>
    <v-row justify="center">
      <v-col cols="12" md="8" sm="12">
        <v-card outlined elevation="5">
          <v-card-title style="font-family: hanna">
            <font-awesome-icon icon="user-plus" size="lg" />
            <span class="ml-4 font-weight-bold">회원가입</span>
          </v-card-title>
          <v-card-text>
            <member-join />
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import MemberJoin from "@/components/member/MemberJoin.vue";

export default {
  name: "MemberJoinView",
  components: {
    MemberJoin,
  },
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped>
span {
  font-size: 25px;
  padding-top: 3px;
}
</style>
