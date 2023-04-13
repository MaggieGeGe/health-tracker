<template>
  <div>
    <!--search list-->
    <div>
      <el-input style="width: 150px" placeholder="Please input the food name"></el-input>
      <el-input style="width: 150px;margin-left: 10px" placeholder="Please input the type"></el-input>
      <el-button style="margin-left: 10px" type="primary" round>Search</el-button>
    </div>
    <el-table :data="tableData" style="margin-top: 10px" stripe >
      <el-table-column prop="name" label="Name" width="100px"></el-table-column>
      <el-table-column prop="type" label="Type" width="100px"></el-table-column>
      <el-table-column prop="productiondate" label="Production Date"></el-table-column>
      <el-table-column prop="expireddate" label="Expired Date"></el-table-column>
      <el-table-column prop="nutrition" label="Nutrition"></el-table-column>
      <el-table-column prop="amount" label="Amount" width="80px"></el-table-column>
      <el-table-column prop="remainingday" label="Remaining Days"></el-table-column>
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
      tableData: [
        {name: 'ge', type: 18, productiondate:"20220203",expireddate:"20220304",nutrition:"",amount:2,remainingday:3},
        {name: 'ge', type: 18, productiondate:"20220203",expireddate:"20220304",nutrition:"",amount:2,remainingday:3},
        {name: 'ge', type: 18, productiondate:"20220203",expireddate:"20220304",nutrition:"",amount:2,remainingday:3}
      ]
    }
  }
}
</script>

<style scoped>

</style>