const express = require('express')
const nganhhoc_controller = require('../controller/nganhhoc_controller')
const router = express.Router()

// * Get
router.get('/1',nganhhoc_controller.getNganhHoc_1);
router.get('/2',nganhhoc_controller.getNganhHoc_2);


module.exports = router