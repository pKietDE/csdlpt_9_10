const express = require('express')
const truonghoc_controller = require('../controller/truonghoc_controller')
const router = express.Router()

// * Get
router.get('/1',truonghoc_controller.getTruongHoc_1);
router.get('/2',truonghoc_controller.getTruongHoc_2);
router.get('/3',truonghoc_controller.getTruongHoc_3);
router.get('/4',truonghoc_controller.getTruongHoc_4);


module.exports = router