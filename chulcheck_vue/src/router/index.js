import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "main",
    component: HomeView,
  },
  {
    path: "/member",
    name: "member",
    component: () => import(/* webpackChunkName: "member" */ "@/views/MemberJoinView"),
    children: [
      {
        path: "join",
        name: "join",
        component: () => import(/* webpackChunkName: "member" */ "@/components/member/MemberJoin"),
      },
      {
        path: "login",
        name: "login",
        component: () => import(/* webpackChunkName: "member" */ "@/components/member/MemberLogin"),
      },
      // {
      //   path: "delete",
      //   name: "userdelete",
      //   beforeEnter: onlyAuthUser,
      //   component: () => import(/* webpackChunkName: "user" */ "@/components/user/UserDelete"),
      // },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
