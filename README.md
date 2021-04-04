# Release Lab06 Patch Note #
## Task List ##
- [x] Add new feature: class `Media`
- [x] Add new feature: `lucky item`
- [x] Update class `Cart` to adapt `Media`
- [x] Update class `Store` to adapt `Media`
- [x] Update class diagram and usecase diagram
## New Feature ⚡ ##
### 1. Media class and relevance ###
  - The fact that a store does not contain only `DigitalVideoDisc` product, it may contains book, film,... Due to that fact, in this release, I added class `Book` that contains attributes relevant to a book (like `id`, `title`, `category`, `cost`, `authors`). `Book` and `DigitalVideoDisc` have some similar attributes. Hence, it is better to create a class `Media` that contains the shared duplicated attributes in those two classes, and let `Book` and `DigitalVideoDisc` inherit `Media`.
  - Some methods in `Media`:
      - `int eqauls(Media media)`: compare two `Media` object with **case-insensitive**.
      - `boolean search(String title)`: return `true` if this object contains any token in `title`.
      - `void displayDetail()`: print out all attributes of a `Media` class.
### 2. Lucky item ###
Create method `Media getLuckyItem()` in class `Cart`.
### 3. Media Utils ###
Similar to DVDUTils, on purpose of handling the program easie alongside class `Media`, it is better to have a class to compare, and sort `Media` objects.
### 4. Store Utils ###
  - The `Store` class in the previous release (`release/lab05`) packs all operations in one class. This makes the code dirty, and really hard to follow. Hence, I divided it into 33utilities: `ViewStore`, `UpdateStore`, and `SeeCurrentCart`.
## Bug Fixing 🐞 ##
- ❌ Class `Aims` will ~no longer suport adding **media to cart or removing media from cart on Media detail**~.
- ❌ Remove `newDVD()` function from class `DigitalVideoDisc` due to unnecessary use.
## Other updates ###
- Update class diagram and usecase diagram to adapt to this release.
