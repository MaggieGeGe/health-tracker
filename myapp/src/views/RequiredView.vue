<template>
  <div>
    <!--search list-->
    <p>You can set some required food here for you. And once there is not enough food in your grocery, it will alert to let you know.</p>
    <div>
      <el-input style="width: 150px" placeholder="Please input the food name"></el-input>
      <el-input style="width: 150px;margin-left: 10px" placeholder="Please input the type"></el-input>
      <el-button style="margin-left: 10px" type="primary" round>Search</el-button>
    </div>
    <el-table :data="tableData" style="margin-top: 10px" stripe >
      <el-table-column prop="name" label="Name"></el-table-column>
      <el-table-column prop="type" label="Type"></el-table-column>
      <el-table-column prop="nutrition" label="Nutrition"></el-table-column>
      <el-table-column prop="amount" label="Amount"></el-table-column>
    </el-table>
    <div style="margin-top: 30px">
      <el-pagination background page-size="10" layout="prev, pager, next" :total="tableData.length" />
    </div>
  </div>
</template>

<script>

export default {
  name: "requiredView",
  data() {
    return {
      tableData: []
    }
  },
  created(){
    this.load()
  },
  methods:{
    load(){
      fetch('http://localhost:9090/requiredfood/list')
          .then(res=>res.json())
          .then(res =>{
                console.log(res)
                this.tableData = res
              }
          )
    }
  }
}
</script>

<style scoped>

</style>