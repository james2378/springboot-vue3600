<template>
	<div class="diy_edit page_registration_reservation" id="registration_reservation_edit">
		<div class='warp'>
			<div class='container'>
				<div class='row diy_edit_content_box'>
					<div v-if="$check_field('set','department_number') || $check_field('add','department_number') || $check_field('get','department_number')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>科室编号:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_department_number" v-model="form['department_number']" placeholder="请输入科室编号" v-if="(form['department_number'] && $check_field('set','department_number')) || (!form['department_number'] && $check_field('add','department_number'))"  :disabled="disabledObj['department_number_isDisabled']"/>
							<span v-else-if="$check_field('get','department_number')">{{ form['name_of_doctor'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','department_type') || $check_field('add','department_type') || $check_field('get','department_type')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>科室类型:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_department_type" v-model="form['department_type']" placeholder="请输入科室类型" v-if="(form['department_type'] && $check_field('set','department_type')) || (!form['department_type'] && $check_field('add','department_type'))"  :disabled="disabledObj['department_type_isDisabled']"/>
							<span v-else-if="$check_field('get','department_type')">{{ form['name_of_doctor'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','department_name') || $check_field('add','department_name') || $check_field('get','department_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>科室名称:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_department_name" v-model="form['department_name']" placeholder="请输入科室名称" v-if="(form['department_name'] && $check_field('set','department_name')) || (!form['department_name'] && $check_field('add','department_name'))"  :disabled="disabledObj['department_name_isDisabled']"/>
							<span v-else-if="$check_field('get','department_name')">{{ form['name_of_doctor'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','name_of_doctor') || $check_field('add','name_of_doctor') || $check_field('get','name_of_doctor')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>医生姓名:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_name_of_doctor" v-model="form['name_of_doctor']" placeholder="请输入医生姓名" v-if="(form['name_of_doctor'] && $check_field('set','name_of_doctor')) || (!form['name_of_doctor'] && $check_field('add','name_of_doctor'))"  :disabled="disabledObj['name_of_doctor_isDisabled']"/>
							<span v-else-if="$check_field('get','name_of_doctor')">{{ form['name_of_doctor'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','doctor_position') || $check_field('add','doctor_position') || $check_field('get','doctor_position')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>医生职位:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_doctor_position" v-model="form['doctor_position']" placeholder="请输入医生职位" v-if="(form['doctor_position'] && $check_field('set','doctor_position')) || (!form['doctor_position'] && $check_field('add','doctor_position'))"  :disabled="disabledObj['doctor_position_isDisabled']"/>
							<span v-else-if="$check_field('get','doctor_position')">{{ form['name_of_doctor'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','doctor_account') || $check_field('add','doctor_account') || $check_field('get','doctor_account')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>医生账号:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_doctor_account" :disabled="disabledObj['doctor_account_isDisabled']" v-model="form['doctor_account']" v-if="(form['doctor_account'] && $check_field('set','doctor_account')) || (!form['doctor_account'] && $check_field('add','doctor_account'))" >
								<option v-for="o in list_user_doctor_account" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','doctor_account')">{{ form['doctor_account'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','time_of_appointment') || $check_field('add','time_of_appointment') || $check_field('get','time_of_appointment')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>预约时间:
							</span>
						</div>
						<!-- 日期 -->
						<div class="diy_field diy_date">
							<input type="date" :disabled="disabledObj['time_of_appointment_isDisabled']" id="form_time_of_appointment" v-model="form['time_of_appointment']" placeholder="请输入预约时间" v-if="(form['time_of_appointment'] && $check_field('set','time_of_appointment')) || (!form['time_of_appointment'] && $check_field('add','time_of_appointment'))" />
							<span v-else-if="$check_field('get','time_of_appointment')">{{ form['name_of_doctor'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','appointment_description') || $check_field('add','appointment_description') || $check_field('get','appointment_description')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>预约说明:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_appointment_description" v-model="form['appointment_description']" placeholder="请输入预约说明" v-if="(form['appointment_description'] && $check_field('set','appointment_description')) || (!form['appointment_description'] && $check_field('add','appointment_description'))"  :disabled="disabledObj['appointment_description_isDisabled']"/>
							<span v-else-if="$check_field('get','appointment_description')">{{ form['name_of_doctor'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','appointment_name') || $check_field('add','appointment_name') || $check_field('get','appointment_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>预约姓名:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_appointment_name" v-model="form['appointment_name']" placeholder="请输入预约姓名" v-if="(form['appointment_name'] && $check_field('set','appointment_name')) || (!form['appointment_name'] && $check_field('add','appointment_name'))"  :disabled="disabledObj['appointment_name_isDisabled']"/>
							<span v-else-if="$check_field('get','appointment_name')">{{ form['name_of_doctor'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','id') || $check_field('add','id') || $check_field('get','id')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>身份证:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_id" v-model="form['id']" placeholder="请输入身份证" v-if="(form['id'] && $check_field('set','id')) || (!form['id'] && $check_field('add','id'))"  :disabled="disabledObj['id_isDisabled']"/>
							<span v-else-if="$check_field('get','id')">{{ form['name_of_doctor'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','appointment_person') || $check_field('add','appointment_person') || $check_field('get','appointment_person')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>预约人:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_appointment_person" :disabled="disabledObj['appointment_person_isDisabled']" v-model="form['appointment_person']" v-if="(form['appointment_person'] && $check_field('set','appointment_person')) || (!form['appointment_person'] && $check_field('add','appointment_person'))" >
								<option v-for="o in list_user_appointment_person" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','appointment_person')">{{ form['appointment_person'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','time_slot') || $check_field('add','time_slot') || $check_field('get','time_slot')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>时间段:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_time_slot" v-model="form['time_slot']" placeholder="请输入时间段" v-if="(form['time_slot'] && $check_field('set','time_slot')) || (!form['time_slot'] && $check_field('add','time_slot'))"  :disabled="disabledObj['time_slot_isDisabled']"/>
							<span v-else-if="$check_field('get','time_slot')">{{ form['name_of_doctor'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','reservation_number') || $check_field('add','reservation_number') || $check_field('get','reservation_number')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>预约号数:
							</span>
						</div>
						<!-- 数字 -->
						<div class="diy_field diy_number">
							<input type="number" id="form_reservation_number" v-model.number="form['reservation_number']" placeholder="请输入预约号数" v-if="(form['reservation_number'] && $check_field('set','reservation_number')) || (!form['reservation_number'] && $check_field('add','reservation_number'))" :disabled="disabledObj['reservation_number_isDisabled']" />
							<span v-else-if="$check_field('get','reservation_number')">{{ form['name_of_doctor'] }}</span>
						</div>
					</div>
				</div>
				<div class="diy_edit_submit_box row">
					<div class="col-12">
						<div class="btn_box">
							<button class="btn_submit" @click="submit()">提交</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/page.js";
	export default {
		mixins: [mixin],
		components: {},
		data() {
			return {
				url_get_obj: "~/api/registration_reservation/get_obj?",
				url_add: "~/api/registration_reservation/add?",
				url_set: "~/api/registration_reservation/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
					"department_number": "",
					"department_type": "",
					"department_name": "",
					"name_of_doctor": "",
					"doctor_position": "",
					"doctor_account": 0,
					"time_of_appointment": "",
					"appointment_description": "",
					"appointment_name": "",
					"id": "",
					"appointment_person": 0,
					"time_slot": "",
					"reservation_number": 0,
					"registration_reservation_id": 0,
				},

				obj: {
					"department_number":'', // 科室编号
					"department_type":'', // 科室类型
					"department_name":'', // 科室名称
					"name_of_doctor":'', // 医生姓名
					"doctor_position":'', // 医生职位
					"doctor_account": 0, // 医生账号
					"time_of_appointment": "1970-01-01 00:00:00",
					"appointment_description":'', // 预约说明
					"appointment_name":'', // 预约姓名
					"id":'', // 身份证
					"appointment_person": 0, // 预约人
					"time_slot":'', // 时间段
					"reservation_number":0, // 预约号数
					"registration_reservation_id": 0,
				},

				// 表单字段
				form: {
					"department_number":'', // 科室编号
					"department_type":'', // 科室类型
					"department_name":'', // 科室名称
					"name_of_doctor":'', // 医生姓名
					"doctor_position":'', // 医生职位
					"doctor_account": 0, // 医生账号
					"time_of_appointment": "1970-01-01 00:00:00",
					"appointment_description":'', // 预约说明
					"appointment_name":'', // 预约姓名
					"id":'', // 身份证
					"appointment_person": 0, // 预约人
					"time_slot":'', // 时间段
					"reservation_number":0, // 预约号数
					"registration_reservation_id": 0,

				},
				disabledObj:{
					"department_number_isDisabled": false,
					"department_type_isDisabled": false,
					"department_name_isDisabled": false,
					"name_of_doctor_isDisabled": false,
					"doctor_position_isDisabled": false,
					"doctor_account_isDisabled": false,
					"time_of_appointment_isDisabled": false,
					"appointment_description_isDisabled": false,
					"appointment_name_isDisabled": false,
					"id_isDisabled": false,
					"appointment_person_isDisabled": false,
					"time_slot_isDisabled": false,
				},
				// 用户列表
				list_user_doctor_account: [],
				// 用户列表
				list_user_appointment_person: [],

				// ID字段
				field: "registration_reservation_id",
			}
		},
		methods: {
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
			async get_user_session_appointment_person(){
				var _this = this;
				var json = await this.$get("~/api/user_group/get_obj?name=普通用户");
				if(json.result && json.result.obj){
					var source_table = json.result.obj.source_table;
					var user_id = _this.$store.state.user.user_id;
					if (user_id){
						var url = "~/api/"+source_table+"/get_obj?"
						this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
							if (res.result && res.result.obj) {
								var arr = []
								for (let key in res.result.obj) {
									arr.push(key)
								}
								var arrForm = []
								for (let key in _this.form) {
									arrForm.push(key)
								}
								_this.form["appointment_person"] = user_id
								_this.disabledObj['appointment_person' + '_isDisabled'] = true
								for (var i=0;i<arr.length;i++){
									for (var j=0;j<arrForm.length;j++){
										if (arr[i]===arrForm[j]){
											if (arr[i]!=="appointment_person") {
												_this.form[arrForm[j]] = res.result.obj[arr[i]]
												_this.disabledObj[arrForm[j] + '_isDisabled'] = true
												break;
											}
										}
									}
								}
							}
						});
					}
				}
				else if(json.error){
					console.error(json.error);
				}
			},

			/**
			 * 修改文件
			 * @param { Object } files 上传文件对象
			 * @param { String } str 表单的属性名
			 */
			change_file(files, str) {
				var form = new FormData();
				form.append("file", files[0]);
				this.$post("~/api/registration_reservation/upload?", form, (res) => {
					if (res.result) {
						this.form[str] = res.result.url;
					} else if (res.error) {
						this.$toast(res.error.message);
					}
				});
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_before(param){
				var form = $.db.get("form");
				if (form) {
					this.obj = $.push(this.obj ,form);
					this.form = $.push(this.form ,form);
				}
				var arr = []
				for (let key in form) {
					arr.push(key)
				}
				for (var i=0;i<arr.length;i++){
					this.disabledObj[arr[i] + '_isDisabled'] = true
				}
				this.form["time_of_appointment"] = this.$toTime(parseInt(this.form["time_of_appointment"]),"yyyy-MM-dd")
				return param;
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json ,func){
				var form = $.db.get("form");
				var obj = Object.assign({} ,form ,this.obj);
				if (form) {
					this.obj = $.push(this.obj ,obj);
				}
				if (form) {
					this.form = $.push(this.form ,form);
				}
				if(func){
					func(json);
				}
			},

		},
		created() {
			this.get_list_user_doctor_account();
			this.get_user_session_appointment_person();
			this.get_list_user_appointment_person();
		}
	}
</script>

<style>
</style>
