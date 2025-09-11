package haru.kieu.service;

import java.io.File;
import java.util.List;

import haru.kieu.dao.CategoryDao;
import haru.kieu.dao.CategoryDaoImpl;
import haru.kieu.model.Category;
import haru.kieu.util.Constant;

public class CategoryServiceImpl implements CategoryService {

	private final CategoryDao categoryDao = new CategoryDaoImpl();;

	@Override
	public void insert(Category category) {
		categoryDao.insert(category);

	}

	@Override
	public void edit(Category newCategory) {
		Category oldCategory = categoryDao.get(newCategory.getCateid());
		if (oldCategory == null)
			return;

		oldCategory.setCatename(newCategory.getCatename());
		if (newCategory.getIcon() != null) {
			String fileName = oldCategory.getIcon();
			if (fileName != null && !fileName.isEmpty()) {
				File file = new File(Constant.DIR + "/" + fileName);
				if (file.exists())
					file.delete();
			}
			oldCategory.setIcon(newCategory.getIcon());
		}
		categoryDao.edit(oldCategory);

	}

	@Override
	public void delete(int id) {
		Category c = categoryDao.get(id);
		if (c != null && c.getIcon() != null) {
			File file = new File(Constant.DIR + "/" + c.getIcon());
			if (file.exists())
				file.delete();
		}
		categoryDao.delete(id);

	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return categoryDao.get(id);
	}

	@Override
	public Category get(String name) {
		// TODO Auto-generated method stub
		return categoryDao.get(name);
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return categoryDao.getAll();
	}

	@Override
	public List<Category> search(String keyword) {
		// TODO Auto-generated method stub
		return categoryDao.search(keyword);
	}

}
