const express = require('express')
const duhocsinh_controller = require('../controller/duhocsinh_controller')
const router = express.Router()

// * Get
router.get('/1',duhocsinh_controller.getDuHocSinh_1);
router.get('/2',duhocsinh_controller.getDuHocSinh_2);
router.get('/3',duhocsinh_controller.getDuHocSinh_3);


module.exports = router