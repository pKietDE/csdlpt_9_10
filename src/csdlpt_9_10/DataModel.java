package csdlpt_9_10;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.ConnectException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class DataModel {

    public ArrayList<ArrayList<String>> get(String url, String[] tenCot) throws JSONException, IOException, InterruptedException {
        ArrayList<ArrayList<String>> datalist = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        System.out.println("Response from API (" + url + "): " + response.body());
        if (response.body().isEmpty()) {
            return datalist;
        }

        JSONArray jsonArray = new JSONArray(response.body());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            ArrayList<String> row = new ArrayList<>();

            // Thêm dữ liệu theo thứ tự cột được chỉ định
            for (String colName : tenCot) {
                row.add(obj.optString(colName, ""));
            }

            datalist.add(row);
        }
        return datalist;
    }

    public DefaultTableModel addTableModel(DefaultTableModel tableModel,
            ArrayList<ArrayList<String>> d,
            String tenCot[]) {
        if (tableModel == null) {
            tableModel = new DefaultTableModel(tenCot, 0);
        }
        for (int i = 0; i < d.size(); i++) {
            Object o[] = new Object[tenCot.length];
            for (int j = 0; j < d.get(i).size(); j++) {
                o[j] = d.get(i).get(j);
            }
            tableModel.addRow(o);
        }
        return tableModel;
    }

    public ArrayList<ArrayList<String>> ket(ArrayList<ArrayList<String>> a, ArrayList<ArrayList<String>> b) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        // Tạo một HashMap để lưu trữ dữ liệu từ danh sách thứ hai (b) theo MASANPHAM
        HashMap<String, ArrayList<String>> mapB = new HashMap<>();
        for (ArrayList<String> itemB : b) {
            if (!itemB.isEmpty()) {
                mapB.put(itemB.get(0), itemB); // Lấy MASANPHAM làm key
            }
        }

        // Kết hợp dữ liệu từ danh sách a với dữ liệu tương ứng từ danh sách b
        for (ArrayList<String> itemA : a) {
            if (!itemA.isEmpty()) {
                String maSP = itemA.get(0); // Lấy MASANPHAM từ danh sách a

                ArrayList<String> combined = new ArrayList<>();

                // Thêm tất cả dữ liệu từ danh sách a
                combined.addAll(itemA);

                // Thêm dữ liệu từ danh sách b (ngoại trừ MASANPHAM vì đã có từ a)
                if (mapB.containsKey(maSP)) {
                    ArrayList<String> itemB = mapB.get(maSP);
                    for (int i = 1; i < itemB.size(); i++) {
                        combined.add(itemB.get(i));
                    }
                }

                // Loại bỏ các cột rỗng (nếu muốn)
                ArrayList<String> finalCombined = new ArrayList<>();
                for (String value : combined) {
                    if (value != null && !value.trim().isEmpty()) {
                        finalCombined.add(value);
                    }
                }

                result.add(finalCombined);
            }
        }

        System.out.println("Dữ liệu sau khi kết hợp: " + result);
        return result;
    }

    public DefaultTableModel getTableModel(String[] tenCot, ArrayList<ArrayList<String>> d) {
        DefaultTableModel tableModel = new DefaultTableModel(tenCot, 0);
        for (int i = 0; i < d.size(); i++) {
            Object o[] = new Object[tenCot.length];
            for (int j = 0; j < d.get(i).size(); j++) {
                o[j] = d.get(i).get(j);
            }
            tableModel.addRow(o);
        }
        return tableModel;
    }

    public ArrayList<ArrayList<String>> getManhTruongHoc(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String[] tenCot, String endpoint) {
        if (f == null) {
            return null;
        }

        ArrayList<String> aIP = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<ArrayList<String>> a = null;
        for (String ip : aIP) {
            String url = "http://" + ip + ":3000/truonghoc/" + endpoint;
            DataModel db = new DataModel();
            try {
                a = db.get(url, tenCot);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText() + "\n" + url + " Down";
                txtError.setText(s);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return a;
    }

    public ArrayList<ArrayList<String>> getManhDuHocSinh(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String[] tenCot, String endpoint) {
        if (f == null) {
            return null;
        }

        ArrayList<String> aIP = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<ArrayList<String>> a = null;
        for (String ip : aIP) {
            String url = "http://" + ip + ":3000/duhocsinh/" + endpoint;
            DataModel db = new DataModel();
            try {
                a = db.get(url, tenCot);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText() + "\n" + url + " Down";
                txtError.setText(s);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return a;
    }

    public ArrayList<ArrayList<String>> getManhNganhHoc(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String[] tenCot, String endpoint) {
        if (f == null) {
            return null;
        }

        ArrayList<String> aIP = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<ArrayList<String>> a = null;
        for (String ip : aIP) {
            String url = "http://" + ip + ":3000/nganhhoc/" + endpoint;
            DataModel db = new DataModel();
            try {
                a = db.get(url, tenCot);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText() + "\n" + url + " Down";
                txtError.setText(s);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return a;
    }

    public ArrayList<ArrayList<String>> getManhDangKyDuHoc(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String[] tenCot, String endpoint) {
        if (f == null) {
            return null;
        }

        ArrayList<String> aIP = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<ArrayList<String>> a = null;
        for (String ip : aIP) {
            String url = "http://" + ip + ":3000/dangkyduhoc/" + endpoint;
            DataModel db = new DataModel();
            try {
                a = db.get(url, tenCot);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText() + "\n" + url + " Down";
                txtError.setText(s);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return a;
    }

    public void DanhSachDuHocSinhDangKy(DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String tenTruong, ArrayList<ArrayList<String>> truonghoc,
            ArrayList<ArrayList<String>> duhocsinh, ArrayList<ArrayList<String>> dangkyduhoc) {

        // * bước 1  Lọc danh sách trường theo tên nhập vào
        txtError.append("Bước 1\n");
        ArrayList<ArrayList<String>> truongFiltered = truonghoc.stream()
                .filter(row -> row.get(1).equalsIgnoreCase(tenTruong))
                .collect(Collectors.toCollection(ArrayList::new));
        txtError.append("Kết quả : " + truongFiltered.toString() + "\n");

        // * bước 2 Tạo ánh xạ MATR -> TruongHoc
        txtError.append("Bước 2\n");

        Map<String, ArrayList<String>> mapTruong = new HashMap<>();
        for (ArrayList<String> row : truongFiltered) {
            mapTruong.put(row.get(0), row); // MATR làm key
        }
        txtError.append("Kết quả : " + mapTruong.toString() + "\n");

        // * bước 3  Lọc danh sách đăng ký du học
        txtError.append("Bước 3\n");

        ArrayList<ArrayList<String>> dangKyFiltered = dangkyduhoc.stream()
                .filter(row -> mapTruong.containsKey(row.get(1))) // Chỉ lấy những đăng ký có trong bảng trường
                .collect(Collectors.toCollection(ArrayList::new));
        txtError.append("Kết quả : " + dangKyFiltered.toString() + "\n");

        // * Bước 4 Tạo ánh xạ MADHS -> TGHOC và MADHS -> MATR
        txtError.append("Bước 4\n");

        Map<String, String> mapDangKy = new HashMap<>();
        Map<String, String> mapDHS_MATR = new HashMap<>();

        for (ArrayList<String> row : dangKyFiltered) {
            mapDangKy.put(row.get(0), row.get(4)); // MADHS -> TGHOC
            mapDHS_MATR.put(row.get(0), row.get(1)); // MADHS -> MATR
        }
        txtError.append("Kết quả : " + mapDangKy + "\n");

        // * Bước 5 Lọc danh sách du học sinh
        txtError.append("Bước 5\n");

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (ArrayList<String> row : duhocsinh) {
            String madhs = row.get(0);
            if (mapDangKy.containsKey(madhs)) {
                String tghoc = mapDangKy.get(madhs);
                String matr = mapDHS_MATR.get(madhs); // Lấy MATR từ ánh xạ MADHS -> MATR

                if (matr != null && mapTruong.containsKey(matr)) {
                    ArrayList<String> truongInfo = mapTruong.get(matr);

                    ArrayList<String> newRow = new ArrayList<>();
                    newRow.add(row.get(1)); // HOTEN
                    newRow.add(row.get(3)); // IELTS
                    newRow.add(truongInfo.get(1)); // TENTRUONG
                    newRow.add(truongInfo.get(2)); // QUOCGIA
                    newRow.add(tghoc); // TGHOC

                    result.add(newRow);
                }
            }
        }
        txtError.append("Kết quả : " + result.toString() + "\n");

        // * Bước 6 Hiển thị dữ liệu lên bảng
        String[] columns = {"HOTEN", "IELTS", "TENTRUONG", "QUOCGIA", "TGHOC"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (ArrayList<String> row : result) {
            model.addRow(row.toArray());
        }

        tblResult.setModel(model);
    }

    public void DanhSachDuHocSinhRot(DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, ArrayList<ArrayList<String>> dangkyduhoc,
            ArrayList<ArrayList<String>> nganhhoc, ArrayList<ArrayList<String>> duhocsinh) {
        // * Bước 1: Tạo ánh xạ MANG -> IELTS yêu cầu (NganhHoc)
        Map<String, String> mapNganhIELTS = new HashMap<>();
        for (ArrayList<String> row : nganhhoc) {
            mapNganhIELTS.put(row.get(0), row.get(2)); // MANG -> IELTS yêu cầu
        }

        // * Bước 2: Tạo ánh xạ MADHS -> HOTEN, IELTS từ DuHocSinh
        Map<String, ArrayList<String>> mapDuHocSinh = new HashMap<>();
        for (ArrayList<String> row : duhocsinh) {
            mapDuHocSinh.put(row.get(0), new ArrayList<>(Arrays.asList(row.get(1), row.get(3)))); // MADHS -> [HOTEN, IELTS]
        }

        // * Bước 3: Lọc danh sách du học sinh rớt
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (ArrayList<String> row : dangkyduhoc) {
            String madhs = row.get(0);
            String mang = row.get(2);

            if (mapDuHocSinh.containsKey(madhs) && mapNganhIELTS.containsKey(mang)) {
                ArrayList<String> dhsInfo = mapDuHocSinh.get(madhs);
                String hoten = dhsInfo.get(0);
                double dhsIELTS = Double.parseDouble(dhsInfo.get(1)); // IELTS du học sinh
                double nganhIELTS = Double.parseDouble(mapNganhIELTS.get(mang)); // IELTS yêu cầu

                if (dhsIELTS < nganhIELTS) { // Nếu IELTS của DHS nhỏ hơn yêu cầu
                    ArrayList<String> newRow = new ArrayList<>();
                    newRow.add(madhs);
                    newRow.add(hoten);
                    newRow.add(mang);
                    newRow.add(String.valueOf(dhsIELTS));
                    newRow.add(String.valueOf(nganhIELTS));
                    result.add(newRow);
                }
            }
        }

        // * Bước 4: Hiển thị danh sách lên bảng
        String[] columns = {"MADHS", "HOTEN", "MANG", "IELTS DHS", "IELTS Yêu Cầu"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (ArrayList<String> row : result) {
            model.addRow(row.toArray());
        }

        tblResult.setModel(model);
    }

    public ArrayList<ArrayList<String>> gopManh(ArrayList<ArrayList<String>>... datasets) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        // Add all rows from all datasets to the result
        for (ArrayList<ArrayList<String>> dataset : datasets) {
            if (dataset != null) {
                result.addAll(dataset);
            }
        }

        return result;
    }

}
