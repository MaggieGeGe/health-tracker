<template>
  <div>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">Mainpage</el-breadcrumb-item>
      <el-breadcrumb-item :to="{ path: '/grocery' }">GroceryInfo</el-breadcrumb-item>
    </el-breadcrumb>
    <!--search list-->
    <div style="margin-top: 10px">
      <el-input
          style="width: 250px"
          placeholder="Please input the food name"
          clearable
      >
        <template #suffix><el-icon><Search /></el-icon></template>
      </el-input>
      <el-input
          style="width: 250px;margin-left: 10px"
          placeholder="Please input the type"
      >
        <template #suffix><el-icon><Search /></el-icon></template>
      </el-input>
      <el-button style="margin-left: 10px" type="primary" round>Search</el-button>
    </div>
    <div style="padding: 10px 0">
      <el-button type="primary" style="width: 100px;">Add <el-icon><CirclePlus /></el-icon></el-button>
      <el-button type="danger" style="width: 100px;">Delete <el-icon><CircleClose /></el-icon></el-button>
      <el-button type="primary" style="width: 100px;">Upload <el-icon><Upload /></el-icon></el-button>
      <el-button type="primary" style="width: 100px;">Download <el-icon><Download /></el-icon></el-button>
    </div>
    <el-table :data="tableData" style="margin-top: 10px;margin-left: 0px" stripe header-cell-class-name="headerBg">
      <el-table-column prop="name" label="Name" width="150px"></el-table-column>
      <el-table-column prop="type" label="Type" width="80px"></el-table-column>
      <el-table-column prop="productiondate" label="Production Date"  width="140px"></el-table-column>
      <el-table-column prop="expireddate" label="Expired Date"  width="120px"></el-table-column>
      <el-table-column prop="nutrition" label="Nutrition"  width="120px"></el-table-column>
      <el-table-column prop="amount" label="Amount" width="80px"></el-table-column>
      <el-table-column prop="remainingday" label="Remaining Days"  width="140px"></el-table-column>
      <el-table-column label="Operation">
          <el-button type="success" style="width: 70px;">Edit <el-icon><Edit /></el-icon></el-button>
          <el-button type="danger" style="width: 70px;">Delete <el-icon><CircleClose /></el-icon></el-button>
      </el-table-column>
    </el-table>
    <div style="margin-top: 30px">
      <el-pagination
          v-model:current-page="currentPage3"
          v-model:page-size="pageSize3"
          :page-sizes="[10,20,50,100, 200, 300, 400]"
          :small="small"
          :disabled="disabled"
          :background="background"
          layout="sizes, prev, pager, next, jumper"
          :total="1000"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      />
    </div>
  </div>
</template>
<script>

import {CircleClose, Search} from "@element-plus/icons-vue";
export default {
  name: "requiredView",
  components: {CircleClose, Search},
  data() {
    const generateExampleData = () => ({
      name: "Example Food",
      type: "Type",
      productiondate: "2023-07-01",
      expireddate: "2023-07-10",
      nutrition: "Nutrition",
      amount: Math.floor(Math.random() * 10) + 1,
      remainingday: Math.floor(Math.random() * 10) + 1
    });

    return {
      tableData: Array.from({ length: 20 }, generateExampleData),
      headerBg:"headerBg"
    };

  }
  // created(){
  //   this.load()
  // },
  // methods:{
  //   load(){
  //     fetch().then(res=>res.json()).then(res =>{
  //       console.log(res)
  //       this.tableData = res
  //     })
  //   }
  // }
}
</script>
<style>
.headerBg {
  background-color: #edf3fc !important;
}
</style>