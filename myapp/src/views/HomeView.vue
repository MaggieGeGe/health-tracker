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
      <el-button style="margin-left: 10px" type="warning" round @click="reset">Reset</el-button>
    </div>
    <div style="padding: 10px 0">
      <el-button type="primary" style="width: 100px;" @click="handleAdd">Add <el-icon><CirclePlus /></el-icon></el-button>
      <el-popconfirm
          confirm-button-text="Yes"
          cancel-button-text="No"
          :icon="InfoFilled"
          icon-color="#626AEF"
          title="Are you sure to delete all?"
          @confirm="delBatch"
      >
        <template #reference>
          <el-button type="danger" style="width: 100px;">Delete <el-icon><CircleClose /></el-icon></el-button>
        </template>
      </el-popconfirm>
      <el-button type="primary" style="width: 100px;">Upload <el-icon><Upload /></el-icon></el-button>
      <el-button type="primary" style="width: 100px;">Download <el-icon><Download /></el-icon></el-button>
    </div>
    <el-table :data="tableData" style="margin-top: 10px" stripe @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" />
      <el-table-column prop="id" label="Id" width="60px"></el-table-column>
      <el-table-column prop="name" label="Name" ></el-table-column>
      <el-table-column prop="username" label="UserName"></el-table-column>
      <el-table-column prop="age" label="Age" width="80px"></el-table-column>
      <el-table-column prop="sex" label="Sex"  width="80px"></el-table-column>
      <el-table-column prop="phone" label="Phone"></el-table-column>
      <el-table-column label="Operation">
        <template #default="scope">
          <el-button type="success" style="width: 70px;" @click="handleEdit(scope.row)">Edit <el-icon><Edit /></el-icon></el-button>
          <el-popconfirm
              confirm-button-text="Yes"
              cancel-button-text="No"
              :icon="InfoFilled"
              icon-color="#626AEF"
              title="Are you sure to delete this?"
              @confirm="del(scope.row.id)"
          >
            <template #reference>
              <el-button type="danger" style="width: 70px;">Delete <el-icon><CircleClose /></el-icon></el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin-top: 30px">
      <el-pagination
          v-model:page-size = "pageSize"
          :page-sizes="[5,10,20,50,100]"
          :current-page = "pageNum"
          :small="false"
          :disabled="false"
          :background="false"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      />
    </div>
  </div>
  <el-dialog v-model="dialogFormVisible" title="User Information" width="35%">
    <el-form :model="form">
      <el-form-item label="Name" :label-width="formLabelWidth" >
        <el-input v-model="form.name" autocomplete="off" />
      </el-form-item>
      <el-form-item label="Username" :label-width="formLabelWidth">
        <el-input v-model="form.username" autocomplete="off" />
      </el-form-item>
      <el-form-item label="Age" :label-width="formLabelWidth">
        <el-input v-model="form.age" autocomplete="off" />
      </el-form-item>
      <el-form-item label="Sex" :label-width="formLabelWidth">
        <el-select :modelValue="form.sex" placeholder="Please select your sex" @update:modelValue="form.sex = $event">
          <el-option label="female" value="female" />
          <el-option label="male" value="male" />
        </el-select>
      </el-form-item>
      <el-form-item label="Phone" :label-width="formLabelWidth">
        <el-input v-model="form.phone" autocomplete="off" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="save">
          Confirm
        </el-button>
      </span>
    </template>
  </el-dialog>


</template>

<script>
import {request} from "axios";
import { InfoFilled } from '@element-plus/icons-vue';



export default {
  name: 'HomeView',
  components:{
    InfoFilled,
  },
  data(){
    return {
      tableData:[],
      total:0,
      pageNum:1,
      pageSize: 5,
      username:"",
      phoneNum:"",
      form:{},
      formLabelWidth: '100px',
      dialogFormVisible :false,
      multipleSelection : []
    }
  },
  created(){
    //request sbupage data
    this.load()
  },
  methods:{
    load(){
      this.$axios.get("http://localhost:9090/user/page",{
        params:{
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          username: this.username,
          phone: this.phoneNum
        }
      })
          .then(res=>{
            console.log(res)
          this.tableData = res.data.records
          this.total = res.data.total
      }).catch(error => {
            console.error("请求数据时出错：" + error)})


    },
    save(){
      this.$axios.post("http://localhost:9090/user",this.form).then(
          res=>{
            if(res){
              this.$message.success("Save Succeed")
              this.dialogFormVisible = false
            } else {
              this.$message.error("Save failed")
            }
          }
      )
      this.load()

    },
    reset(){
      this.username = ""
      this.phoneNum = ""
    },
    handleAdd(){
      this.dialogFormVisible = true
      this.form = {}
    },
    handleEdit(row){
      this.form = row
      this.dialogFormVisible = true
    },
    del(index){
      this.$axios.delete("http://localhost:9090/user/"+index).then(res=>{
        if(res){
          this.$message.success("Delete Succeed")

        } else {
          this.$message.error("Delete failed")
        }
      })
      this.load()

    },
    delBatch(){
      let ids = this.multipleSelection.map(v => v.id)
      this.$axios.post("http://localhost:9090/user/del/batch",ids).then(res=>{
        if(res){
          this.$message.success("Delete All Succeed")
        } else {
          this.$message.error("Delete All Failed")
        }
      })
      this.load()
    },
    handleSelectionChange(val){
      console.log(val)
      this.multipleSelection =val
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
