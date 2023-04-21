INSERT INTO
    category(id, name, description)
VALUES
    (1, 'Elektronika', 'Zaopatrz się w najwyższej jakości sprzęt elektroniczny'),
    (2, 'Meble', 'Stylowe i starannie wykonane meble'),
    (3, 'Ogród', 'Sprzęt ogrodowy, który ułatwi Ci pracę'),
    (4, 'Moda', 'Najnowsze trendy i kolekcje');

INSERT INTO
    offer(title, description, imgUrl, price, category_id)
VALUES
    ('Telewizor', 'Telewizor z technologią OLED, każdy obraz wciąga swoim bogactwem barw.',
     'https://www.mediaexpert.pl/media/cache/resolve/filemanager_original/images/descriptions/images/28/2809603/storage_app_opisy2_lg_400062/telewizor_lg_r19la_1_banner.jpg',
     6299, 1),
    ('Samsung Galaxy S22', 'Wybierz smartfon, w którym zastosowano najszybszy w historii Galaxy procesor oraz pamięć RAM 8 GB',
     'https://www.tabletowo.pl/wp-content/uploads/2023/04/Samsung-Galaxy-A24-zrodlo-Samsung-4.jpg', 6799, 1),
    ('Komoda','Komoda wyróżnia się efektownym, lecz prostym designem.', 'https://www.meblemagnat.pl/environment/cache/images/800_800_productGfx_23787/render_sosna_zmiany_.RGB_color.0010.png',
     2079,2),
    ('Szafka nocna', 'Szafka nocna stanowi praktyczny element wyposażenia sypialnianego wnętrza.',
    'https://www.meblemagnat.pl/environment/cache/images/800_800_productGfx_23970/mega-dab.jpg', 259, 2),
    ('Kosiarka', 'Kosiarka spalinowa to przydatne urządzenie w każdym ogrodzie.',
    'https://media.castorama.pl/media/catalog/product/K/o/Kosiarka_spalinowa_z_napedem_MacAllister_B_S_550E_46_cm-634217-613287.webp',
     1398, 3),
    ('Taczka', 'Prezentowa taczka przyda Ci się do ogrodu czy na działkę',
    'https://media.castorama.pl/media/catalog/product/T/a/Taczka_ogrodowa_Verve_malowana_60_l_-627145-358051.webp',
     148, 3),
    ('Szpilki', 'W tych obcasach podbijesz świat!', 'https://img.eobuwie.cloud/eob1_product_650w(a/0/4/e/a04e63f9770c392b09496e88241dbdfc2a6f1281_01_0000302053711_mg.jpg,webp)/szpilki-guess---felyx4-carry-over-fl7fl4-pat08-black.webp',
     629, 4),
    ('Sweter', 'W tym ciepłym swetrze, już nigdy nie zmarzniesz!', 'https://eolsen.pl/userdata/public/gfx/17435/Sweter-damski-w-paski---Limited-modelka.jpg',
     159,4);