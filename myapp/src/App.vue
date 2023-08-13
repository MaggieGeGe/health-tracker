<template>
  <div id="app">
    <!--add head part-->
    <div style="height: 60px;line-height: 60px;margin-bottom:4px ;background-color: #f3cde2">
      <img src="@/assets/logo.png" alt="" style="width:40px;left: 30px; position: relative; top: 10px">
      <span style="margin-left: 60px;font-size: 24px;font-family:Serif,cursive;font-weight: bold">GeYe's NewWebsite</span>
    </div>

    <!--side part -->
    <div style="display: flex">


      <div style="width:220px; overflow: hidden;margin-left: 5px;margin-right: 4px;background-color: #f3ebf1">
        <el-menu :default-active="$router.path" router class="el-menu-demo" @select="handleSelect">
          <el-menu-item index="/">
              <el-icon color="#000000"><Menu /></el-icon>
              <span>MainPage</span>
          </el-menu-item>
          <el-sub-menu>
            <template #title>
              <el-icon><Refrigerator /></el-icon>
              <span>GroceryInfo</span>
            </template>
            <el-menu-item index="/grocery">
              <el-icon><ShoppingCartFull /></el-icon>
              <span>Grocery One</span>
            </el-menu-item>
            <el-menu-item index="">
              <el-icon><ShoppingCartFull /></el-icon>Grocery Two
            </el-menu-item>
            <el-menu-item index="">
              <el-icon><ShoppingCartFull /></el-icon>Grocery Three
            </el-menu-item>
          </el-sub-menu>
          <el-menu-item index="/requiredfood">
            <el-icon><Star /></el-icon>Required Food
          </el-menu-item>
          <el-menu-item index="/caloriesquery">
            <el-icon><View /></el-icon>Calories Query
          </el-menu-item>
          <el-menu-item index="/recipe">
            <el-icon><ChatLineSquare /></el-icon>
            Recipe Suggestion
          </el-menu-item>
          <el-menu-item index="/profile">
            <el-icon><User /></el-icon>
            Profile
          </el-menu-item>
        </el-menu>
      </div>
      <!-- body data-->
      <div style="flex:1;background-color: #d1ddf1; padding:10px;margin-right: 10px">
        <router-view/>
      </div>

    </div>

  </div>
</template>

<script>
import {
  Menu,
  ChatLineSquare,
  User,
  View,
  Star,
  ShoppingCartFull,
  Refrigerator
} from "@element-plus/icons-vue";
export default {
  components: {Menu,ChatLineSquare,User,View,Star,ShoppingCartFull,Refrigerator}
}
</script>