<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','department_number') || $check_field('add','department_number') || $check_field('set','department_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="科室编号" prop="department_number">
					<el-input id="department_number" v-model="form['department_number']" placeholder="请输入科室编号"
							  v-if="user_group === '管理员' || (form['cancellation_of_registration_id'] && $check_field('set','department_number')) || (!form['cancellation_of_registration_id'] && $check_field('add','department_number'))" :disabled="disabledObj['department_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','department_number')">{{form['department_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','department_type') || $check_field('add','department_type') || $check_field('set','department_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="科室类型" prop="department_type">
					<el-input id="department_type" v-model="form['department_type']" placeholder="请输入科室类型"
							  v-if="user_group === '管理员' || (form['cancellation_of_registration_id'] && $check_field('set','department_type')) || (!form['cancellation_of_registration_id'] && $check_field('add','department_type'))" :disabled="disabledObj['department_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','department_type')">{{form['department_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','department_name') || $check_field('add','department_name') || $check_field('set','department_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="科室名称" prop="department_name">
					<el-input id="department_name" v-model="form['department_name']" placeholder="请输入科室名称"
							  v-if="user_group === '管理员' || (form['cancellation_of_registration_id'] && $check_field('set','department_name')) || (!form['cancellation_of_registration_id'] && $check_field('add','department_name'))" :disabled="disabledObj['department_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','department_name')">{{form['department_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','name_of_doctor') || $check_field('add','name_of_doctor') || $check_field('set','name_of_doctor')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="医生姓名" prop="name_of_doctor">
					<el-input id="name_of_doctor" v-model="form['name_of_doctor']" placeholder="请输入医生姓名"
							  v-if="user_group === '管理员' || (form['cancellation_of_registration_id'] && $check_field('set','name_of_doctor')) || (!form['cancellation_of_registration_id'] && $check_field('add','name_of_doctor'))" :disabled="disabledObj['name_of_doctor_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','name_of_doctor')">{{form['name_of_doctor']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','doctor_position') || $check_field('add','doctor_position') || $check_field('set','doctor_position')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="医生职位" prop="doctor_position">
					<el-input id="doctor_position" v-model="form['doctor_position']" placeholder="请输入医生职位"
							  v-if="user_group === '管理员' || (form['cancellation_of_registration_id'] && $check_field('set','doctor_position')) || (!form['cancellation_of_registration_id'] && $check_field('add','doctor_position'))" :disabled="disabledObj['doctor_position_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','doctor_position')">{{form['doctor_position']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','doctor_account') || $check_field('add','doctor_account') || $check_field('set','doctor_account')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="医生账号" prop="doctor_account">
					<el-input id="doctor_account" v-model="form['doctor_account']" placeholder="请输入医生账号"
							  v-if="user_group === '管理员' || (form['cancellation_of_registration_id'] && $check_field('set','doctor_account')) || (!form['cancellation_of_registration_id'] && $check_field('add','doctor_account'))" :disabled="disabledObj['doctor_account_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','doctor_account')">{{form['doctor_account']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','cancel_time') || $check_field('add','cancel_time') || $check_field('set','cancel_time')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="取消时间" prop="cancel_time">
					<el-date-picker :disabled="disabledObj['cancel_time_isDisabled']" v-if="user_group === '管理员' || (form['cancellation_of_registration_id'] && $check_field('set','cancel_time')) || (!form['cancellation_of_registration_id'] && $check_field('add','cancel_time'))" id="cancel_time"
						v-model="form['cancel_time']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','cancel_time')">{{form['cancel_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','canceller') || $check_field('add','canceller') || $check_field('set','canceller')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="取消人" prop="canceller">
						<div v-if="user_group !== '管理员'">
							{{ get_user_session_canceller(form['canceller']) }}
							<!--<el-input id="business_name" v-model="form['canceller']" placeholder="请输入取消人"-->
							<!--v-if="user_group === '管理员' || (form['cancellation_of_registration_id'] && $check_field('set','canceller')) || (!form['cancellation_of_registration_id'] && $check_field('add','canceller'))" :disabled="disabledObj['canceller_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','canceller')">{{form['canceller']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['cancellation_of_registration_id'] && $check_field('set','canceller')) || (!form['cancellation_of_registration_id'] && $check_field('add','canceller'))" id="canceller" v-model="form['canceller']" :disabled="disabledObj['canceller_isDisabled']">
								<el-option v-for="o in list_user_canceller" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','canceller')" id="canceller" v-model="form['canceller']" :disabled="true">
								<el-option v-for="o in list_user_canceller" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="canceller" v-model="form['canceller']" :disabled="disabledObj['canceller_isDisabled']">
							<el-option v-for="o in list_user_canceller" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','cancellation_reason') || $check_field('add','cancellation_reason') || $check_field('set','cancellation_reason')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="取消原因" prop="cancellation_reason">
					<el-input type="textarea" id="cancellation_reason" v-model="form['cancellation_reason']" placeholder="请输入取消原因"
						v-if="user_group === '管理员' || (form['cancellation_of_registration_id'] && $check_field('set','cancellation_reason')) || (!form['cancellation_of_registration_id'] && $check_field('add','cancellation_reason'))" :disabled="disabledObj['cancellation_reason_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','cancellation_reason')">{{form['cancellation_reason']}}</div>
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
				field: "cancellation_of_registration_id",
				url_add: "~/api/cancellation_of_registration/add?",
				url_set: "~/api/cancellation_of_registration/set?",
				url_get_obj: "~/api/cancellation_of_registration/get_obj?",
				url_upload: "~/api/cancellation_of_registration/upload?",

				query: {
					"cancellation_of_registration_id": 0,
				},

				form: {
					"department_number":'', // 科室编号
					"department_type":'', // 科室类型
					"department_name":'', // 科室名称
					"name_of_doctor":'', // 医生姓名
					"doctor_position":'', // 医生职位
					"doctor_account":'', // 医生账号
					"cancel_time":'', // 取消时间
					"canceller": 0, // 取消人
					"cancellation_reason":'', // 取消原因
					"cancellation_of_registration_id": 0, // ID

				},
				disabledObj:{
					"department_number_isDisabled": false,
					"department_type_isDisabled": false,
					"department_name_isDisabled": false,
					"name_of_doctor_isDisabled": false,
					"doctor_position_isDisabled": false,
					"doctor_account_isDisabled": false,
					"cancel_time_isDisabled": false,
					"canceller_isDisabled": false,
					"cancellation_reason_isDisabled": false,
				},
				// 用户列表
				list_user_canceller: [],
				// 用户组
				group_user_canceller: "",

			}
		},
		methods: {
			/**
			 * 获取普通用户用户列表
			 */
			async get_list_user_canceller() {
                // if(this.user_group !== "管理员" && this.form["canceller"] === 0) {
                //     this.form["canceller"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=普通用户");
                if(json.result && json.result.list){
                    this.list_user_canceller = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
			/**
			 * 获取普通用户用户组
			 */
			async get_group_user_canceller() {
				this.form["canceller"] = this.user.user_id;
				var json = await this.$get("~/api/user_group/get_obj?name=普通用户");
				if(json.result && json.result.obj){
					this.group_user_canceller = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_canceller(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_canceller.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
						for (let key in _this.form) {
							arrForm.push(key)
						}
						for (var i=0;i<arr.length;i++){
							for (var j=0;j<arrForm.length;j++){
								if (arr[i]===arrForm[j]){
									if (arr[i]!=="canceller") {
										_this.form[arrForm[j]] = res.result.obj[arr[i]]
										_this.disabledObj[arrForm[j] + '_isDisabled'] = true
										break;
									}else {
										_this.disabledObj[arrForm[j] + '_isDisabled'] = true
									}
								}
							}
						}
					}
				});
			},
			get_user_canceller(id){
				var obj = this.list_user_canceller.getObj({"user_id":id});
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
				// 获取缓存数据附加
				form = $.db.get("form");
				$.push(this.form ,form);
				/**
				* 请求列表前
				* @param {Object} param
				*/
				var user_group = this.user.user_group;
				if (user_group !== "管理员") {
					switch (user_group) {
						case "取消人":
							if(param["canceller"] > 0){
								param["canceller"] = this.user.user_id;
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
        if (this.form["cancel_time"].indexOf("-")===-1){
          this.form["cancel_time"] = this.$toTime(parseInt(this.form["cancel_time"]),"yyyy-MM-dd")
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
				if(parseInt(this.form["cancel_time"]) > 9999){
					this.form["cancel_time"] = this.$toTime(parseInt(this.form["cancel_time"]),"yyyy-MM-dd")
				}

			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/cancellation_of_registration/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/cancellation_of_registration/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/cancellation_of_registration/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/cancellation_of_registration/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/cancellation_of_registration/view','get');
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
			this.get_list_user_canceller();
			this.get_group_user_canceller();
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
