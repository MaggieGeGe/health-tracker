<template>
  <div>
    <el-table :data="tableData" style="margin-top: 10px" stripe >
      <el-table-column prop="id" label="Id" width="60px"></el-table-column>
      <el-table-column prop="name" label="Name" ></el-table-column>
      <el-table-column prop="username" label="UserName"></el-table-column>
      <el-table-column prop="age" label="Age"></el-table-column>
      <el-table-column prop="sex" label="Sex"></el-table-column>
      <el-table-column prop="phone" label="Phone"></el-table-column>
    </el-table>
  </div>
</template>

<script>

export default {
  name: 'HomeView',
  data(){
    return {
      tableData:[]
    }
  },
  created(){
    this.load()

  },
  methods:{
    load(){
      fetch('http://localhost:9090/user/list').then(res=>res.json()).then(res =>{
        console.log(res)
        this.tableData = res
      })
    }
  }
}
</script>
