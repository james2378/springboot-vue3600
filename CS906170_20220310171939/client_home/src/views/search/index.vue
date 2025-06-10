<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>
				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="医院资讯"
				source_table="article"
			  ></list_result_search>
				<!-- 论坛搜索结果 -->
			  <list_result_search
				:list="result_forum"
				title="医院论坛"
				source_table="forum"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/ordinary_users/list', 'get')"
				:list="result_ordinary_users_gender"
				title="普通用户性别"
				source_table="ordinary_users"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/doctor/list', 'get')"
				:list="result_doctor_gender"
				title="医生性别"
				source_table="doctor"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/department_information/list', 'get')"
				:list="result_department_information_department_type"
				title="科室信息科室类型"
				source_table="department_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/department_information/list', 'get')"
				:list="result_department_information_department_name"
				title="科室信息科室名称"
				source_table="department_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/nucleic_acid_appointment/list', 'get')"
				:list="result_nucleic_acid_appointment_appointment_name"
				title="核酸预约预约姓名"
				source_table="nucleic_acid_appointment"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/nucleic_acid_appointment/list', 'get')"
				:list="result_nucleic_acid_appointment_id"
				title="核酸预约身份证"
				source_table="nucleic_acid_appointment"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/registration_reservation/list', 'get')"
				:list="result_registration_reservation_department_type"
				title="挂号预约科室类型"
				source_table="registration_reservation"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/registration_reservation/list', 'get')"
				:list="result_registration_reservation_department_name"
				title="挂号预约科室名称"
				source_table="registration_reservation"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/registration_reservation/list', 'get')"
				:list="result_registration_reservation_appointment_name"
				title="挂号预约预约姓名"
				source_table="registration_reservation"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/registration_reservation/list', 'get')"
				:list="result_registration_reservation_id"
				title="挂号预约身份证"
				source_table="registration_reservation"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/cancellation_of_registration/list', 'get')"
				:list="result_cancellation_of_registration_department_type"
				title="挂号取消科室类型"
				source_table="cancellation_of_registration"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/cancellation_of_registration/list', 'get')"
				:list="result_cancellation_of_registration_department_name"
				title="挂号取消科室名称"
				source_table="cancellation_of_registration"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/patient_medical_record/list', 'get')"
				:list="result_patient_medical_record_department_type"
				title="患者病历科室类型"
				source_table="patient_medical_record"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/patient_medical_record/list', 'get')"
				:list="result_patient_medical_record_department_name"
				title="患者病历科室名称"
				source_table="patient_medical_record"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/patient_medical_record/list', 'get')"
				:list="result_patient_medical_record_appointment_name"
				title="患者病历预约姓名"
				source_table="patient_medical_record"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/patient_medical_record/list', 'get')"
				:list="result_patient_medical_record_id"
				title="患者病历身份证"
				source_table="patient_medical_record"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/nucleic_acid_results/list', 'get')"
				:list="result_nucleic_acid_results_appointment_name"
				title="核酸结果预约姓名"
				source_table="nucleic_acid_results"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/nucleic_acid_results/list', 'get')"
				:list="result_nucleic_acid_results_id"
				title="核酸结果身份证"
				source_table="nucleic_acid_results"
			  ></list_result_search>
			</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_article": [],
	  "result_forum": [],
			"result_ordinary_users_gender":[],
			"result_doctor_gender":[],
			"result_department_information_department_type":[],
			"result_department_information_department_name":[],
			"result_nucleic_acid_appointment_appointment_name":[],
			"result_nucleic_acid_appointment_id":[],
			"result_registration_reservation_department_type":[],
			"result_registration_reservation_department_name":[],
			"result_registration_reservation_appointment_name":[],
			"result_registration_reservation_id":[],
			"result_cancellation_of_registration_department_type":[],
			"result_cancellation_of_registration_department_name":[],
			"result_patient_medical_record_department_type":[],
			"result_patient_medical_record_department_name":[],
			"result_patient_medical_record_appointment_name":[],
			"result_patient_medical_record_id":[],
			"result_nucleic_acid_results_appointment_name":[],
			"result_nucleic_acid_results_id":[],
	};
  },
  methods: {
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},
	/**
	 * 获取医院论坛
	 */
	get_forum() {
	  this.$get("~/api/forum/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_forum = json.result.list;
		}
	  });
	},
	/**
	 * 获取gender
	 */
	get_ordinary_users_gender(){
		this.$get("~/api/ordinary_users/get_list?like=0", { page: 1, size: 10, "gender": this.query.word }, (json) => {
		  if (json.result) {
			var result_ordinary_users_gender = json.result.list;
			result_ordinary_users_gender.map(o => o.title = o['gender'])
	  			this.result_ordinary_users_gender = result_ordinary_users_gender
		 	}
		});
	},
	/**
	 * 获取gender
	 */
	get_doctor_gender(){
		this.$get("~/api/doctor/get_list?like=0", { page: 1, size: 10, "gender": this.query.word }, (json) => {
		  if (json.result) {
			var result_doctor_gender = json.result.list;
			result_doctor_gender.map(o => o.title = o['gender'])
	  			this.result_doctor_gender = result_doctor_gender
		 	}
		});
	},
	/**
	 * 获取department_type
	 */
	get_department_information_department_type(){
		this.$get("~/api/department_information/get_list?like=0", { page: 1, size: 10, "department_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_department_information_department_type = json.result.list;
			result_department_information_department_type.map(o => o.title = o['department_type'])
	  			this.result_department_information_department_type = result_department_information_department_type
		 	}
		});
	},
	/**
	 * 获取department_name
	 */
	get_department_information_department_name(){
		this.$get("~/api/department_information/get_list?like=0", { page: 1, size: 10, "department_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_department_information_department_name = json.result.list;
			result_department_information_department_name.map(o => o.title = o['department_name'])
	  			this.result_department_information_department_name = result_department_information_department_name
		 	}
		});
	},
	/**
	 * 获取appointment_name
	 */
	get_nucleic_acid_appointment_appointment_name(){
		this.$get("~/api/nucleic_acid_appointment/get_list?like=0", { page: 1, size: 10, "appointment_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_nucleic_acid_appointment_appointment_name = json.result.list;
			result_nucleic_acid_appointment_appointment_name.map(o => o.title = o['appointment_name'])
	  			this.result_nucleic_acid_appointment_appointment_name = result_nucleic_acid_appointment_appointment_name
		 	}
		});
	},
	/**
	 * 获取id
	 */
	get_nucleic_acid_appointment_id(){
		this.$get("~/api/nucleic_acid_appointment/get_list?like=0", { page: 1, size: 10, "id": this.query.word }, (json) => {
		  if (json.result) {
			var result_nucleic_acid_appointment_id = json.result.list;
			result_nucleic_acid_appointment_id.map(o => o.title = o['id'])
	  			this.result_nucleic_acid_appointment_id = result_nucleic_acid_appointment_id
		 	}
		});
	},
	/**
	 * 获取department_type
	 */
	get_registration_reservation_department_type(){
		this.$get("~/api/registration_reservation/get_list?like=0", { page: 1, size: 10, "department_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_registration_reservation_department_type = json.result.list;
			result_registration_reservation_department_type.map(o => o.title = o['department_type'])
	  			this.result_registration_reservation_department_type = result_registration_reservation_department_type
		 	}
		});
	},
	/**
	 * 获取department_name
	 */
	get_registration_reservation_department_name(){
		this.$get("~/api/registration_reservation/get_list?like=0", { page: 1, size: 10, "department_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_registration_reservation_department_name = json.result.list;
			result_registration_reservation_department_name.map(o => o.title = o['department_name'])
	  			this.result_registration_reservation_department_name = result_registration_reservation_department_name
		 	}
		});
	},
	/**
	 * 获取appointment_name
	 */
	get_registration_reservation_appointment_name(){
		this.$get("~/api/registration_reservation/get_list?like=0", { page: 1, size: 10, "appointment_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_registration_reservation_appointment_name = json.result.list;
			result_registration_reservation_appointment_name.map(o => o.title = o['appointment_name'])
	  			this.result_registration_reservation_appointment_name = result_registration_reservation_appointment_name
		 	}
		});
	},
	/**
	 * 获取id
	 */
	get_registration_reservation_id(){
		this.$get("~/api/registration_reservation/get_list?like=0", { page: 1, size: 10, "id": this.query.word }, (json) => {
		  if (json.result) {
			var result_registration_reservation_id = json.result.list;
			result_registration_reservation_id.map(o => o.title = o['id'])
	  			this.result_registration_reservation_id = result_registration_reservation_id
		 	}
		});
	},
	/**
	 * 获取department_type
	 */
	get_cancellation_of_registration_department_type(){
		this.$get("~/api/cancellation_of_registration/get_list?like=0", { page: 1, size: 10, "department_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_cancellation_of_registration_department_type = json.result.list;
			result_cancellation_of_registration_department_type.map(o => o.title = o['department_type'])
	  			this.result_cancellation_of_registration_department_type = result_cancellation_of_registration_department_type
		 	}
		});
	},
	/**
	 * 获取department_name
	 */
	get_cancellation_of_registration_department_name(){
		this.$get("~/api/cancellation_of_registration/get_list?like=0", { page: 1, size: 10, "department_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_cancellation_of_registration_department_name = json.result.list;
			result_cancellation_of_registration_department_name.map(o => o.title = o['department_name'])
	  			this.result_cancellation_of_registration_department_name = result_cancellation_of_registration_department_name
		 	}
		});
	},
	/**
	 * 获取department_type
	 */
	get_patient_medical_record_department_type(){
		this.$get("~/api/patient_medical_record/get_list?like=0", { page: 1, size: 10, "department_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_patient_medical_record_department_type = json.result.list;
			result_patient_medical_record_department_type.map(o => o.title = o['department_type'])
	  			this.result_patient_medical_record_department_type = result_patient_medical_record_department_type
		 	}
		});
	},
	/**
	 * 获取department_name
	 */
	get_patient_medical_record_department_name(){
		this.$get("~/api/patient_medical_record/get_list?like=0", { page: 1, size: 10, "department_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_patient_medical_record_department_name = json.result.list;
			result_patient_medical_record_department_name.map(o => o.title = o['department_name'])
	  			this.result_patient_medical_record_department_name = result_patient_medical_record_department_name
		 	}
		});
	},
	/**
	 * 获取appointment_name
	 */
	get_patient_medical_record_appointment_name(){
		this.$get("~/api/patient_medical_record/get_list?like=0", { page: 1, size: 10, "appointment_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_patient_medical_record_appointment_name = json.result.list;
			result_patient_medical_record_appointment_name.map(o => o.title = o['appointment_name'])
	  			this.result_patient_medical_record_appointment_name = result_patient_medical_record_appointment_name
		 	}
		});
	},
	/**
	 * 获取id
	 */
	get_patient_medical_record_id(){
		this.$get("~/api/patient_medical_record/get_list?like=0", { page: 1, size: 10, "id": this.query.word }, (json) => {
		  if (json.result) {
			var result_patient_medical_record_id = json.result.list;
			result_patient_medical_record_id.map(o => o.title = o['id'])
	  			this.result_patient_medical_record_id = result_patient_medical_record_id
		 	}
		});
	},
	/**
	 * 获取appointment_name
	 */
	get_nucleic_acid_results_appointment_name(){
		this.$get("~/api/nucleic_acid_results/get_list?like=0", { page: 1, size: 10, "appointment_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_nucleic_acid_results_appointment_name = json.result.list;
			result_nucleic_acid_results_appointment_name.map(o => o.title = o['appointment_name'])
	  			this.result_nucleic_acid_results_appointment_name = result_nucleic_acid_results_appointment_name
		 	}
		});
	},
	/**
	 * 获取id
	 */
	get_nucleic_acid_results_id(){
		this.$get("~/api/nucleic_acid_results/get_list?like=0", { page: 1, size: 10, "id": this.query.word }, (json) => {
		  if (json.result) {
			var result_nucleic_acid_results_id = json.result.list;
			result_nucleic_acid_results_id.map(o => o.title = o['id'])
	  			this.result_nucleic_acid_results_id = result_nucleic_acid_results_id
		 	}
		});
	},

  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_article();
	this.get_forum();
		this.get_ordinary_users_gender();
		this.get_doctor_gender();
		this.get_department_information_department_type();
		this.get_department_information_department_name();
		this.get_nucleic_acid_appointment_appointment_name();
		this.get_nucleic_acid_appointment_id();
		this.get_registration_reservation_department_type();
		this.get_registration_reservation_department_name();
		this.get_registration_reservation_appointment_name();
		this.get_registration_reservation_id();
		this.get_cancellation_of_registration_department_type();
		this.get_cancellation_of_registration_department_name();
		this.get_patient_medical_record_department_type();
		this.get_patient_medical_record_department_name();
		this.get_patient_medical_record_appointment_name();
		this.get_patient_medical_record_id();
		this.get_nucleic_acid_results_appointment_name();
		this.get_nucleic_acid_results_id();
  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_article();
	  this.get_forum();
	  this.get_ordinary_users_gender();
	  this.get_doctor_gender();
	  this.get_department_information_department_type();
	  this.get_department_information_department_name();
	  this.get_nucleic_acid_appointment_appointment_name();
	  this.get_nucleic_acid_appointment_id();
	  this.get_registration_reservation_department_type();
	  this.get_registration_reservation_department_name();
	  this.get_registration_reservation_appointment_name();
	  this.get_registration_reservation_id();
	  this.get_cancellation_of_registration_department_type();
	  this.get_cancellation_of_registration_department_name();
	  this.get_patient_medical_record_department_type();
	  this.get_patient_medical_record_department_name();
	  this.get_patient_medical_record_appointment_name();
	  this.get_patient_medical_record_id();
	  this.get_nucleic_acid_results_appointment_name();
	  this.get_nucleic_acid_results_id();
	},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
