-- Categories --
INSERT INTO categories (id, name, description) VALUES ('585b3cd5-6e96-4ce7-b386-a92fe9a56399','TRAVEL','Mochilas para viajar') ON CONFLICT (id) DO NOTHING;
INSERT INTO categories (id, name, description) VALUES ('8314d61a-ed57-4a05-8880-5b145e3ddd2b','SCHOOL','Mochilas para la escuela') ON CONFLICT (id) DO NOTHING;
INSERT INTO categories (id, name, description) VALUES ('4efe81fa-5323-4272-b6cf-efcb34410de8','SPORT','Mochilas deportivas') ON CONFLICT (id) DO NOTHING;
INSERT INTO categories (id, name, description) VALUES ('a6dd311a-f982-4428-b69d-cff11b7eab14','WORK','Mochilas para el trabajo') ON CONFLICT (id) DO NOTHING;

-- Roles --
INSERT INTO roles (id, name, description) VALUES ('86791af0-92ed-4d10-945b-9356b8bf73ac','USER','Role user') ON CONFLICT (id) DO NOTHING;
INSERT INTO roles (id, name, description) VALUES ('2efe839d-817d-420f-bfb7-bb7028d8258d','ADMIN','Role admin') ON CONFLICT (id) DO NOTHING;

-- Products --
INSERT INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES ('bcbed0d0-ce17-4a9a-81ec-40a8bcd9f018','Producto A','Descripción del producto A', 'www.productoA.com',1000.0, 100, true,'585b3cd5-6e96-4ce7-b386-a92fe9a56399');
INSERT INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES ('dea2d2d7-02ff-4773-9b0a-8122d75c2ddb','Producto B','Descripción del producto B', 'www.productoB.com',1000.0, 100, true,'8314d61a-ed57-4a05-8880-5b145e3ddd2b');
INSERT INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES ('7cca74c1-e372-44d8-b82b-060da8a184ab','Producto C','Descripción del producto C', 'www.productoC.com',1000.0, 100, true,'4efe81fa-5323-4272-b6cf-efcb34410de8');
INSERT INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES ('30a7b1e8-c8b0-45ac-958b-13a7fda4314e','Producto D','Descripción del producto D', 'www.productoD.com',1000.0, 100, true,'a6dd311a-f982-4428-b69d-cff11b7eab14');
