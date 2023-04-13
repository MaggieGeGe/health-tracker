<template>
  <div id="app">
    <!--add head part-->
    <div style="height: 60px;line-height: 60px;background-color: #f3cde2">
      <img src="@/assets/logo.png" alt="" style="width:40px;left: 30px; position: relative; top: 10px">
      <span style="margin-left: 60px;font-size: 24px;font-family:Serif,cursive;font-weight: bold">GeYe's NewWebsite</span>
    </div>

    <!--side part -->
    <div style="display: flex">

      <div style="width:200px; overflow: hidden;margin-right: 2px;background-color: #f3ebf1">
        <el-menu :default-active="$router.path" router class="el-menu-demo" @select="handleSelect">
          <el-menu-item index="/">Processing Centerrr</el-menu-item>
          <el-sub-menu index="2">
            <template #title>Workspace</template>
            <el-menu-item index="/about">about</el-menu-item>
            <el-menu-item index="2-2">item two</el-menu-item>
            <el-menu-item index="2-3">item three</el-menu-item>
            <el-sub-menu index="2-4">
              <template #title>item four</template>
              <el-menu-item index="2-4-1">item one</el-menu-item>
              <el-menu-item index="2-4-2">item two</el-menu-item>
              <el-menu-item index="2-4-3">item three</el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-menu-item index="3" disabled>Info</el-menu-item>
          <el-menu-item index="4">Orders</el-menu-item>
        </el-menu>
      </div>
      <!-- body data-->
      <div style="flex:1;background-color: #d1ddf1">
        <router-view/>
      </div>

    </div>

  </div>
</template>

