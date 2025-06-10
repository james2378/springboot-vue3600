<template>
	<div class="diy_edit page_nucleic_acid_appointment" id="nucleic_acid_appointment_edit">
		<div class='warp'>
			<div class='container'>
				<div class='row diy_edit_content_box'>
					<div v-if="$check_field('set','reservation_number') || $check_field('add','reservation_number') || $check_field('get','reservation_number')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>预约编号:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_reservation_number" v-model="form['reservation_number']" placeholder="请输入预约编号" v-if="(form['reservation_number'] && $check_field('set','reservation_number')) || (!form['reservation_number'] && $check_field('add','reservation_number'))" :disabled="true"/>
							<span v-else-if="$check_field('get','reservation_number')">{{ form['appointment_name'] }}</span>
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
							<span v-else-if="$check_field('get','time_of_appointment')">{{ form['appointment_name'] }}</span>
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
							<span v-else-if="$check_field('get','appointment_name')">{{ form['appointment_name'] }}</span>
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
							<span v-else-if="$check_field('get','id')">{{ form['appointment_name'] }}</span>
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
					<div v-if="$check_field('set','appointment_description') || $check_field('add','appointment_description') || $check_field('get','appointment_description')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>预约说明:
							</span>
						</div>
						<!-- 多文本 -->
						<div class="diy_field diy_desc">
							<textarea id="form_appointment_description" v-model="form['appointment_description']" v-if="(form['appointment_description'] && $check_field('set','appointment_description')) || (!form['appointment_description'] && $check_field('add','appointment_description'))" :disabled="disabledObj['appointment_description_isDisabled']" />
							<span v-else-if="$check_field('get','appointment_description')">{{ form['appointment_name'] }}</span>
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
				url_get_obj: "~/api/nucleic_acid_appointment/get_obj?",
				url_add: "~/api/nucleic_acid_appointment/add?",
				url_set: "~/api/nucleic_acid_appointment/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
					"reservation_number": "",
					"time_of_appointment": "",
					"appointment_name": "",
					"id": "",
					"appointment_person": 0,
					"appointment_description": "",
					"nucleic_acid_appointment_id": 0,
				},

				obj: {
					"reservation_number":this.$get_stamp(), // 预约编号
					"time_of_appointment": "1970-01-01 00:00:00",
					"appointment_name":'', // 预约姓名
					"id":'', // 身份证
					"appointment_person": 0, // 预约人
					"appointment_description":'', // 预约说明
					"nucleic_acid_appointment_id": 0,
				},

				// 表单字段
				form: {
					"reservation_number":this.$get_stamp(), // 预约编号
					"time_of_appointment": "1970-01-01 00:00:00",
					"appointment_name":'', // 预约姓名
					"id":'', // 身份证
					"appointment_person": 0, // 预约人
					"appointment_description":'', // 预约说明
					"nucleic_acid_appointment_id": 0,

				},
				disabledObj:{
					"reservation_number_isDisabled": false,
					"time_of_appointment_isDisabled": false,
					"appointment_name_isDisabled": false,
					"id_isDisabled": false,
					"appointment_person_isDisabled": false,
					"appointment_description_isDisabled": false,
				},
				// 用户列表
				list_user_appointment_person: [],

				// ID字段
				field: "nucleic_acid_appointment_id",
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
				this.$post("~/api/nucleic_acid_appointment/upload?", form, (res) => {
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
			this.get_user_session_appointment_person();
			this.get_list_user_appointment_person();
		}
	}
</script>

<style>
</style>
