const {DuHocSinh} = require('../models/duhocsinh')

exports.getDuHocSinh_1 = async (req,res)  => {
    try {
        let dataDuHocSinh_1 = await DuHocSinh.getDuHocSinh_1();
        res.status(200).json(dataDuHocSinh_1);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}
exports.getDuHocSinh_2 = async (req,res)  => {
    try {
        let dataDuHocSinh_2 = await DuHocSinh.getDuHocSinh_2();
        res.status(200).json(dataDuHocSinh_2);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}
exports.getDuHocSinh_3 = async (req,res)  => {
    try {
        let dataDuHocSinh_3 = await DuHocSinh.getDuHocSinh_3();
        res.status(200).json(dataDuHocSinh_3);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}
