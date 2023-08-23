<template>
  <div>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">Mainpage</el-breadcrumb-item>
    </el-breadcrumb>
    <!--search list-->
    <div style="margin-top: 10px">
      <el-input
          style="width: 250px"
          placeholder="Please input the username"
          v-model="username"
          clearable
      >
        <template #suffix><el-icon><Search /></el-icon></template>
      </el-input>
      <el-input
          style="width: 250px;margin-left: 10px"
          placeholder="Please input the phone number"
          v-model="phoneNum"
          clearable
      >
        <template #suffix><el-icon><Search /></el-icon></template>
      </el-input>
      <el-button style="margin-left: 10px" type="primary" round @click="load">Search</el-button>
    </div>
    <div style="padding: 10px 0">
      <el-button type="primary" style="width: 100px;">Add <el-icon><CirclePlus /></el-icon></el-button>
      <el-button type="danger" style="width: 100px;">Delete <el-icon><CircleClose /></el-icon></el-button>
      <el-button type="primary" style="width: 100px;">Upload <el-icon><Upload /></el-icon></el-button>
      <el-button type="primary" style="width: 100px;">Download <el-icon><Download /></el-icon></el-button>
    </div>
    <el-table :data="tableData" style="margin-top: 10px" stripe >
      <el-table-column prop="id" label="Id" width="60px"></el-table-column>
      <el-table-column prop="name" label="Name" ></el-table-column>
      <el-table-column prop="username" label="UserName"></el-table-column>
      <el-table-column prop="age" label="Age" width="80px"></el-table-column>
      <el-table-column prop="sex" label="Sex"  width="80px"></el-table-column>
      <el-table-column prop="phone" label="Phone"></el-table-column>
      <el-table-column label="Operation">
        <el-button type="success" style="width: 70px;">Edit <el-icon><Edit /></el-icon></el-button>
        <el-button type="danger" style="width: 70px;">Delete <el-icon><CircleClose /></el-icon></el-button>
      </el-table-column>
    </el-table>
    <div style="margin-top: 30px">
      <el-pagination
          v-model:current-page="currentPage3"
          v-model:page-size="pageSize3"
          :page-sizes="[5,10,20,50,100]"
          :current-page = "pageNum"
          :page-size = "pageSize"
          :small="small"
          :disabled="disabled"
          :background="background"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      />
    </div>
  </div>
</template>

<script>

export default {
  name: 'HomeView',
  data(){
    return {
      tableData:[],
      total:0,
      pageNum:1,
      pageSize: 5,
      username:"",
      phoneNum:""
    }
  },
  created(){
    //request sbupage data
    this.load()
  },
  methods:{
    load(){
      fetch("http://localhost:9090/user/page?pageNum="+this.pageNum+
          "&pageSize="+this.pageSize+"&username="+
          this.username+"&phone="+this.phoneNum).then(res=>res.json()).then(res =>{
        console.log(res)
        this.tableData = res.data
        this.total = res.total
      })

    },
    handleSizeChange(pageSize){
      console.log(pageSize)
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum){
      console.log(pageNum)
      this.pageNum = pageNum
      this.load()
    }
  }
}
</script>
