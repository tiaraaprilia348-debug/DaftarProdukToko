# Daftar Produk Toko — JavaFX + Maven

Project ini dibuat agar bisa dibuka sebagai **Maven Project** di Apache NetBeans dan file FXML-nya dapat diedit menggunakan Scene Builder.

## Fitur
- Katalog produk berbentuk kartu.
- Pencarian berdasarkan nama dan filter kategori.
- Form tambah produk dengan validasi nama dan harga.
- Tabel daftar produk.
- Halaman detail dari produk yang dipilih.
- Data contoh: Roti Cokelat, Susu UHT, dan Keripik Kentang.
- Data disimpan sementara di memori selama aplikasi berjalan.

## Cara membuka di Apache NetBeans
1. Ekstrak ZIP terlebih dahulu.
2. Buka Apache NetBeans.
3. Pilih **File > Open Project**.
4. Pilih folder `DaftarProdukTokoKatalog` (folder yang berisi `pom.xml`), lalu klik Open Project.
5. Tunggu Maven mengunduh dependency JavaFX.
6. Klik kanan project > **Clean and Build**, lalu **Run**.

Gunakan JDK 17 atau lebih baru. Project menggunakan JavaFX 21.0.2.

## Membuka FXML di Scene Builder
File FXML berada di:
`src/main/resources/kelas/`

- `katalog.fxml` — halaman katalog.
- `form.fxml` — halaman tambah produk.
- `daftar.fxml` — tabel produk.
- `detail.fxml` — halaman detail.

Di NetBeans, buka tab Files/Projects, cari file FXML, klik kanan lalu pilih **Open** atau **Open in Scene Builder** jika tersedia. Alternatifnya, buka Scene Builder secara langsung lalu pilih **File > Open** dan pilih file FXML tersebut.

### Menghubungkan Scene Builder ke NetBeans
Jika menu Scene Builder belum muncul:
1. Buka **Tools > Options**.
2. Cari bagian **Java > JavaFX** (letaknya dapat berbeda menurut versi NetBeans).
3. Isi lokasi aplikasi Scene Builder pada kolom Scene Builder Home/Executable.
4. Klik OK, lalu coba klik kanan file `.fxml` lagi.

Jika versi NetBeans tidak menyediakan pengaturan tersebut, FXML tetap bisa dibuka langsung dari aplikasi Scene Builder melalui **File > Open**. Scene Builder tidak perlu dijalankan melalui Maven.

## Catatan
- Struktur layout halaman ada di FXML sehingga dapat diedit melalui Scene Builder.
- Kartu produk di katalog dibuat secara dinamis oleh Java karena jumlah kartu mengikuti data produk.
- Setelah mengubah FXML/CSS, simpan file dan jalankan ulang aplikasi untuk melihat hasilnya.
