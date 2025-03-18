const {DangKyDuHoc} = require('../models/dangkyduhoc')

exports.getDangKyDuHoc_1 = async (req,res)  => {
    try {
        let dataDangKyDuHoc_1 = await DangKyDuHoc.getDangKyDuHoc_1();
        res.status(200).json(dataDangKyDuHoc_1);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}
exports.getDangKyDuHoc_2 = async (req,res)  => {
    try {
        let dataDangKyDuHoc_2 = await DangKyDuHoc.getDangKyDuHoc_2();
        res.status(200).json(dataDangKyDuHoc_2);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}
exports.getDangKyDuHoc_3 = async (req,res)  => {
    try {
        let dataDangKyDuHoc_3 = await DangKyDuHoc.getDangKyDuHoc_3();
        res.status(200).json(dataDangKyDuHoc_3);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}
