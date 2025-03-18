const express = require('express')
const dangkyduhoc_controller = require('../controller/dangkyduhoc_controller')
const router = express.Router()

// * Get
router.get('/1',dangkyduhoc_controller.getDangKyDuHoc_1);
router.get('/2',dangkyduhoc_controller.getDangKyDuHoc_2);
router.get('/3',dangkyduhoc_controller.getDangKyDuHoc_3);


module.exports = router