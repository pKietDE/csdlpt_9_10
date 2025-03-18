const {TruongHoc} = require('../models/truonghoc')

exports.getTruongHoc_1 = async (req,res)  => {
    try {
        let dataTruongHoc_1 = await TruongHoc.getTruongHoc_1();
        res.status(200).json(dataTruongHoc_1);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}
exports.getTruongHoc_2 = async (req,res)  => {
    try {
        let dataTruongHoc_2 = await TruongHoc.getTruongHoc_2();
        res.status(200).json(dataTruongHoc_2);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}
exports.getTruongHoc_3 = async (req,res)  => {
    try {
        let dataTruongHoc_3 = await TruongHoc.getTruongHoc_3();
        res.status(200).json(dataTruongHoc_3);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}
exports.getTruongHoc_4 = async (req,res)  => {
    try {
        let dataTruongHoc_4 = await TruongHoc.getTruongHoc_4();
        res.status(200).json(dataTruongHoc_4);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}