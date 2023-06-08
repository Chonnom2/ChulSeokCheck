<template>
  <v-app>
    <v-app-bar app color="primary" dark>
      <div class="d-flex align-center" style="cursor: pointer">
        <font-awesome-icon
          icon="calendar-check"
          style="color: #ffcc00"
          size="2x"
          @click="$router.push({ name: 'main' })"
        />
        <span class="chulcheck-title" @click="$router.push({ name: 'main' })">출첵</span>
      </div>

      <v-spacer></v-spacer>

      <v-menu bottom left>
        <!--open-on-hover-->
        <template v-slot:activator="{ on, attrs }">
          <v-btn dark icon v-bind="attrs" v-on="on">
            <font-awesome-icon icon="bars" size="2x" />
          </v-btn>
        </template>

        <v-list>
          <v-list-item v-for="(item, i) in beforeMenu" :key="i" @click="handleClick(i)">
            <v-list-item-icon class="item-icon">
              <font-awesome-icon :icon="item.icon" size="lg" />
            </v-list-item-icon>
            <v-list-item-title> {{ item.title }}</v-list-item-title>
            <!-- <router-link>{{ itme.title }}</router-link> -->
          </v-list-item>
        </v-list>
      </v-menu>
    </v-app-bar>

    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<style>
@font-face {
  font-family: "hanna";
  src: url("assets/fonts/ttf/BMHANNA_11yrs_ttf.ttf");
}

@font-face {
  font-family: "nanum";
  src: url("assets/fonts/ttf/NanumSquareNeo-bRg.ttf");
}

* {
  font-family: nanum;
}
.chulcheck-title {
  font-size: xx-large;
  font-family: hanna;
  padding-top: 7px;
  margin: 0 10px;
}
</style>

<script>
export default {
  name: "App",
  data() {
    return {
      beforeMenu: [
        {
          title: "회원가입",
          icon: "user-plus",
          click() {
            this.$router.push({ name: "join" }).catch(() => {});
          },
        },
        {
          title: "로그인",
          icon: "arrow-right-to-bracket",
          click() {
            this.$router.push({ name: "login" }).catch(() => {});
          },
        },
      ],
    };
  },
  methods: {
    handleClick(index) {
      this.beforeMenu[index].click.call(this);
    },
  },
};
</script>
