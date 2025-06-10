<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','department_number') || $check_field('add','department_number') || $check_field('set','department_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="科室编号" prop="department_number">
					<el-input id="department_number" v-model="form['department_number']" placeholder="请输入科室编号"
							  v-if="user_group === '管理员' || (form['patient_medical_record_id'] && $check_field('set','department_number')) || (!form['patient_medical_record_id'] && $check_field('add','department_number'))" :disabled="disabledObj['department_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','department_number')">{{form['department_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','department_type') || $check_field('add','department_type') || $check_field('set','department_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="科室类型" prop="department_type">
					<el-input id="department_type" v-model="form['department_type']" placeholder="请输入科室类型"
							  v-if="user_group === '管理员' || (form['patient_medical_record_id'] && $check_field('set','department_type')) || (!form['patient_medical_record_id'] && $check_field('add','department_type'))" :disabled="disabledObj['department_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','department_type')">{{form['department_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','department_name') || $check_field('add','department_name') || $check_field('set','department_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="科室名称" prop="department_name">
					<el-input id="department_name" v-model="form['department_name']" placeholder="请输入科室名称"
							  v-if="user_group === '管理员' || (form['patient_medical_record_id'] && $check_field('set','department_name')) || (!form['patient_medical_record_id'] && $check_field('add','department_name'))" :disabled="disabledObj['department_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','department_name')">{{form['department_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','appointment_name') || $check_field('add','appointment_name') || $check_field('set','appointment_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="预约姓名" prop="appointment_name">
					<el-input id="appointment_name" v-model="form['appointment_name']" placeholder="请输入预约姓名"
							  v-if="user_group === '管理员' || (form['patient_medical_record_id'] && $check_field('set','appointment_name')) || (!form['patient_medical_record_id'] && $check_field('add','appointment_name'))" :disabled="disabledObj['appointment_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','appointment_name')">{{form['appointment_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','id') || $check_field('add','id') || $check_field('set','id')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="身份证" prop="id">
					<el-input id="id" v-model="form['id']" placeholder="请输入身份证"
							  v-if="user_group === '管理员' || (form['patient_medical_record_id'] && $check_field('set','id')) || (!form['patient_medical_record_id'] && $check_field('add','id'))" :disabled="disabledObj['id_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','id')">{{form['id']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','appointment_person') || $check_field('add','appointment_person') || $check_field('set','appointment_person')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="预约人" prop="appointment_person">
						<el-select v-if="user_group === '管理员' || (form['patient_medical_record_id'] && $check_field('set','appointment_person')) || (!form['patient_medical_record_id'] && $check_field('add','appointment_person'))" id="appointment_person" v-model="form['appointment_person']" :disabled="disabledObj['appointment_person_isDisabled']">
							<el-option v-for="o in list_user_appointment_person" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','appointment_person')" id="appointment_person" v-model="form['appointment_person']" :disabled="true">
							<el-option v-for="o in list_user_appointment_person" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','doctor_account') || $check_field('add','doctor_account') || $check_field('set','doctor_account')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="医生账号" prop="doctor_account">
						<div v-if="user_group !== '管理员'">
							{{ get_user_session_doctor_account(form['doctor_account']) }}
							<!--<el-input id="business_name" v-model="form['doctor_account']" placeholder="请输入医生账号"-->
							<!--v-if="user_group === '管理员' || (form['patient_medical_record_id'] && $check_field('set','doctor_account')) || (!form['patient_medical_record_id'] && $check_field('add','doctor_account'))" :disabled="disabledObj['doctor_account_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','doctor_account')">{{form['doctor_account']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['patient_medical_record_id'] && $check_field('set','doctor_account')) || (!form['patient_medical_record_id'] && $check_field('add','doctor_account'))" id="doctor_account" v-model="form['doctor_account']" :disabled="disabledObj['doctor_account_isDisabled']">
								<el-option v-for="o in list_user_doctor_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','doctor_account')" id="doctor_account" v-model="form['doctor_account']" :disabled="true">
								<el-option v-for="o in list_user_doctor_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="doctor_account" v-model="form['doctor_account']" :disabled="disabledObj['doctor_account_isDisabled']">
							<el-option v-for="o in list_user_doctor_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','disease_symptoms') || $check_field('add','disease_symptoms') || $check_field('set','disease_symptoms')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="患病症状" prop="disease_symptoms">
					<el-input type="textarea" id="disease_symptoms" v-model="form['disease_symptoms']" placeholder="请输入患病症状"
						v-if="user_group === '管理员' || (form['patient_medical_record_id'] && $check_field('set','disease_symptoms')) || (!form['patient_medical_record_id'] && $check_field('add','disease_symptoms'))" :disabled="disabledObj['disease_symptoms_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','disease_symptoms')">{{form['disease_symptoms']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','cause_of_disease') || $check_field('add','cause_of_disease') || $check_field('set','cause_of_disease')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="患病原因" prop="cause_of_disease">
					<el-input type="textarea" id="cause_of_disease" v-model="form['cause_of_disease']" placeholder="请输入患病原因"
						v-if="user_group === '管理员' || (form['patient_medical_record_id'] && $check_field('set','cause_of_disease')) || (!form['patient_medical_record_id'] && $check_field('add','cause_of_disease'))" :disabled="disabledObj['cause_of_disease_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','cause_of_disease')">{{form['cause_of_disease']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','medication_details') || $check_field('add','medication_details') || $check_field('set','medication_details')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="用药详情" prop="medication_details">
					<el-input type="textarea" id="medication_details" v-model="form['medication_details']" placeholder="请输入用药详情"
						v-if="user_group === '管理员' || (form['patient_medical_record_id'] && $check_field('set','medication_details')) || (!form['patient_medical_record_id'] && $check_field('add','medication_details'))" :disabled="disabledObj['medication_details_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','medication_details')">{{form['medication_details']}}</div>
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
				field: "patient_medical_record_id",
				url_add: "~/api/patient_medical_record/add?",
				url_set: "~/api/patient_medical_record/set?",
				url_get_obj: "~/api/patient_medical_record/get_obj?",
				url_upload: "~/api/patient_medical_record/upload?",

				query: {
					"patient_medical_record_id": 0,
				},

				form: {
					"department_number":'', // 科室编号
					"department_type":'', // 科室类型
					"department_name":'', // 科室名称
					"appointment_name":'', // 预约姓名
					"id":'', // 身份证
					"appointment_person": 0, // 预约人
					"doctor_account": 0, // 医生账号
					"disease_symptoms":'', // 患病症状
					"cause_of_disease":'', // 患病原因
					"medication_details":'', // 用药详情
					"patient_medical_record_id": 0, // ID

				},
				disabledObj:{
					"department_number_isDisabled": false,
					"department_type_isDisabled": false,
					"department_name_isDisabled": false,
					"appointment_name_isDisabled": false,
					"id_isDisabled": false,
					"appointment_person_isDisabled": false,
					"doctor_account_isDisabled": false,
					"disease_symptoms_isDisabled": false,
					"cause_of_disease_isDisabled": false,
					"medication_details_isDisabled": false,
				},
				// 用户列表
				list_user_appointment_person: [],
				// 用户列表
				list_user_doctor_account: [],
				// 用户组
				group_user_doctor_account: "",

			}
		},
		methods: {
			/**
			 * 获取普通用户用户列表
			 */
			async get_list_user_appointment_person() {
                // if(this.user_group !== "管理员" && this.form["appointment_person"] === 0) {
                //     this.form["appointment_person"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=普通用户");
                if(json.result && json.result.list){
                    this.list_user_appointment_person = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
			get_user_appointment_person(id){
				var obj = this.list_user_appointment_person.getObj({"user_id":id});
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
			/**
			 * 获取医生用户组
			 */
			async get_group_user_doctor_account() {
				this.form["doctor_account"] = this.user.user_id;
				var json = await this.$get("~/api/user_group/get_obj?name=医生");
				if(json.result && json.result.obj){
					this.group_user_doctor_account = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_doctor_account(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_doctor_account.source_table+"/get_obj?"
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
									if (arr[i]!=="doctor_account") {
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
						case "预约人":
							if(param["appointment_person"] > 0){
								param["appointment_person"] = this.user.user_id;
							}
							break;
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
					bl = this.$check_action('/patient_medical_record/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/patient_medical_record/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/patient_medical_record/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/patient_medical_record/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/patient_medical_record/view','get');
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
			this.get_list_user_appointment_person();
			this.get_list_user_doctor_account();
			this.get_group_user_doctor_account();
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
