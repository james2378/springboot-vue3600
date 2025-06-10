<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','department_number') || $check_field('add','department_number') || $check_field('set','department_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="科室编号" prop="department_number">
					<el-input id="department_number" v-model="form['department_number']" placeholder="请输入科室编号"
							  v-if="user_group === '管理员' || (form['department_information_id'] && $check_field('set','department_number')) || (!form['department_information_id'] && $check_field('add','department_number'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','department_number')">{{form['department_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','department_type') || $check_field('add','department_type') || $check_field('set','department_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="科室类型" prop="department_type">
					<el-input id="department_type" v-model="form['department_type']" placeholder="请输入科室类型"
							  v-if="user_group === '管理员' || (form['department_information_id'] && $check_field('set','department_type')) || (!form['department_information_id'] && $check_field('add','department_type'))" :disabled="disabledObj['department_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','department_type')">{{form['department_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','department_name') || $check_field('add','department_name') || $check_field('set','department_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="科室名称" prop="department_name">
					<el-input id="department_name" v-model="form['department_name']" placeholder="请输入科室名称"
							  v-if="user_group === '管理员' || (form['department_information_id'] && $check_field('set','department_name')) || (!form['department_information_id'] && $check_field('add','department_name'))" :disabled="disabledObj['department_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','department_name')">{{form['department_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','name_of_doctor') || $check_field('add','name_of_doctor') || $check_field('set','name_of_doctor')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="医生姓名" prop="name_of_doctor">
					<el-input id="name_of_doctor" v-model="form['name_of_doctor']" placeholder="请输入医生姓名"
							  v-if="user_group === '管理员' || (form['department_information_id'] && $check_field('set','name_of_doctor')) || (!form['department_information_id'] && $check_field('add','name_of_doctor'))" :disabled="disabledObj['name_of_doctor_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','name_of_doctor')">{{form['name_of_doctor']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','doctor_position') || $check_field('add','doctor_position') || $check_field('set','doctor_position')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="医生职位" prop="doctor_position">
					<el-input id="doctor_position" v-model="form['doctor_position']" placeholder="请输入医生职位"
							  v-if="user_group === '管理员' || (form['department_information_id'] && $check_field('set','doctor_position')) || (!form['department_information_id'] && $check_field('add','doctor_position'))" :disabled="disabledObj['doctor_position_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','doctor_position')">{{form['doctor_position']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','doctor_head') || $check_field('add','doctor_head') || $check_field('set','doctor_head')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="医生头像" prop="doctor_head">
					<el-upload :disabled="disabledObj['doctor_head_isDisabled']" id="doctor_head" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_doctor_head"
						:show-file-list="false" v-if="user_group === '管理员' || (form['department_information_id'] && $check_field('set','doctor_head')) || (!form['department_information_id'] && $check_field('add','doctor_head'))">
						<img v-if="form['doctor_head']" :src="$fullUrl(form['doctor_head'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','doctor_head')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['doctor_head'])" :preview-src-list="[$fullUrl(form['doctor_head'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','doctor_account') || $check_field('add','doctor_account') || $check_field('set','doctor_account')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="医生账号" prop="doctor_account">
						<el-select v-if="user_group === '管理员' || (form['department_information_id'] && $check_field('set','doctor_account')) || (!form['department_information_id'] && $check_field('add','doctor_account'))" id="doctor_account" v-model="form['doctor_account']" :disabled="disabledObj['doctor_account_isDisabled']">
							<el-option v-for="o in list_user_doctor_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','doctor_account')" id="doctor_account" v-model="form['doctor_account']" :disabled="true">
							<el-option v-for="o in list_user_doctor_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','time_slot') || $check_field('add','time_slot') || $check_field('set','time_slot')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="时间段" prop="time_slot">
					<el-select id="time_slot" v-model="form['time_slot']"
						v-if="user_group === '管理员' || (form['department_information_id'] && $check_field('set','time_slot')) || (!form['department_information_id'] && $check_field('add','time_slot'))">
						<el-option v-for="o in list_time_slot" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','time_slot')">{{form['time_slot']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','remaining_number') || $check_field('add','remaining_number') || $check_field('set','remaining_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="剩余号数" prop="remaining_number">
					<el-input-number id="remaining_number" v-model.number="form['remaining_number']"
						v-if="user_group === '管理员' || (form['department_information_id'] && $check_field('set','remaining_number')) || (!form['department_information_id'] && $check_field('add','remaining_number'))"></el-input-number>
					<div v-else-if="$check_field('get','remaining_number')">{{form['remaining_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','department_profile') || $check_field('add','department_profile') || $check_field('set','department_profile')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="科室简介" prop="department_profile">
					<el-input type="textarea" id="department_profile" v-model="form['department_profile']" placeholder="请输入科室简介"
						v-if="user_group === '管理员' || (form['department_information_id'] && $check_field('set','department_profile')) || (!form['department_information_id'] && $check_field('add','department_profile'))" :disabled="disabledObj['department_profile_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','department_profile')">{{form['department_profile']}}</div>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "department_information_id",
				url_add: "~/api/department_information/add?",
				url_set: "~/api/department_information/set?",
				url_get_obj: "~/api/department_information/get_obj?",
				url_upload: "~/api/department_information/upload?",

				query: {
					"department_information_id": 0,
				},

				form: {
					"department_number":this.$get_stamp(), // 科室编号
					"department_type":'', // 科室类型
					"department_name":'', // 科室名称
					"name_of_doctor":'', // 医生姓名
					"doctor_position":'', // 医生职位
					"doctor_head":'', // 医生头像
					"doctor_account": 0, // 医生账号
					"time_slot":'', // 时间段
					"remaining_number":0, // 剩余号数
					"department_profile":'', // 科室简介
					"department_information_id": 0, // ID

				},
				disabledObj:{
					"department_number_isDisabled": false,
					"department_type_isDisabled": false,
					"department_name_isDisabled": false,
					"name_of_doctor_isDisabled": false,
					"doctor_position_isDisabled": false,
					"doctor_head_isDisabled": false,
					"doctor_account_isDisabled": false,
					"time_slot_isDisabled": false,
					"department_profile_isDisabled": false,
				},
				// 用户列表
				list_user_doctor_account: [],
				//时间段选项列表
				list_time_slot: ['上午场','下午场'],

			}
		},
		methods: {
			/**
			 * 上传医生头像
			 * @param {Object} param图片参数
			 */
			upload_doctor_head(param){
				this.uploadFile(param.file, "doctor_head");
			},
			/**
			 * 获取医生用户列表
			 */
			async get_list_user_doctor_account() {
                // if(this.user_group !== "管理员" && this.form["doctor_account"] === 0) {
                //     this.form["doctor_account"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=医生");
                if(json.result && json.result.list){
                    this.list_user_doctor_account = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
			get_user_doctor_account(id){
				var obj = this.list_user_doctor_account.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
				/**
				* 请求列表前
				* @param {Object} param
				*/
				var user_group = this.user.user_group;
				if (user_group !== "管理员") {
					switch (user_group) {
						case "医生账号":
							if(param["doctor_account"] > 0){
								param["doctor_account"] = this.user.user_id;
							}
							break;
					}
				}
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){

			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/department_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/department_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/department_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/department_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/department_information/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
			this.get_list_user_doctor_account();
		}
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}
</style>
