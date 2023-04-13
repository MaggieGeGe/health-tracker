<template>
  <div>
    <el-table :data="tableData">
      <el-table-column prop="name" label="Name"></el-table-column>
      <el-table-column prop="type" label="Type"></el-table-column>
      <el-table-column prop="productiondate" label="Production Date"></el-table-column>
      <el-table-column prop="expireddate" label="Expired Date"></el-table-column>
      <el-table-column prop="nutrition" label="Nutrition"></el-table-column>
      <el-table-column prop="amount" label="Amount"></el-table-column>
      <el-table-column prop="remainingday" label="Remaining Days"></el-table-column>
    </el-table>
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