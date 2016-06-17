package com.winway.wwapp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.winway.wwapp2.PullDownView.OnPullDownListener;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.Editable.Factory;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class BomActivity extends BaseFragment {
	private Context context;
	private Button btnReturnBom;
	private ImageView btnUp;
	private ImageView btnDown;
	private ImageView btnCounts;
	private EditText txtPartNo;
	private TreeElement element;
	private boolean hasChildren = false;
	private ArrayList<TreeElement> elements;
	private ArrayList<TreeElement> element0;
	private ArrayList<TreeElement> element1;
	private ArrayList<TreeElement> elementsData;
	private ArrayList<Integer> parentlist;
	private ArrayList<Integer> stack;
	private TreeViewAdapter treeViewAdapter;
	private View view;
	private ListView treeview;
	private String action;
	private int cc;
    private boolean isShowTitlebar=true;
	// private DrawerLayout layDrawer;// 側邊MENU
	// private ListView lstDrawer;
	// Function C
	private void closeFragment() {
		if (this.parent != null) {
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(this.parent).commit();
			if(isShowTitlebar)showActionBar();
		}
	}

	// Function I
	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.actbom, container, false);
		context = view.getContext();
		cc = 10;
		hideActionBar();
		initUI(view);
        Bundle b=getArguments();
        if(b!=null&&b.size()>0){
        	txtPartNo.setText(b.getString("bma01"));      
        	queryData(b.getString("bma01"),"down",String.valueOf(cc));
        	isShowTitlebar=false;
        }
		return view;
	}

	private void initUI(View v) {
		if (this.fragmentManager == null) {
			this.fragmentManager = getFragmentManager();
		}
		parentlist = new ArrayList<Integer>();
		// layDrawer = (DrawerLayout)
		// getActivity().findViewById(R.id.drawer_layout);
		// lstDrawer = (ListView) getActivity().findViewById(R.id.left_drawer);
		stack = new ArrayList<Integer>();
		btnReturnBom = (Button) v.findViewById(R.id.btn_return_bom);
		btnDown = (ImageView) v.findViewById(R.id.imgdown);
		btnUp = (ImageView) v.findViewById(R.id.imgup);
		btnCounts = (ImageView) v.findViewById(R.id.imgcounts);
		txtPartNo = (EditText) v.findViewById(R.id.partno);
		treeview = (ListView) v.findViewById(R.id.treeview);
		btnReturnBom.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// show drawer item
				/*
				 * if(layDrawer!=null){ boolean drawerOpen =
				 * layDrawer.isDrawerOpen(lstDrawer); if (drawerOpen) {
				 * layDrawer.closeDrawer(Gravity.LEFT); } else {
				 * layDrawer.openDrawer(Gravity.LEFT); } }
				 */
				if(parent!=null) {
					closeFragment();
				}
				else {
					((MainActivity)getActivity()).returnInventory(null);

				}
			}
		});
		btnUp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// exit without type anything
				if (txtPartNo.getText().toString() == "") {
					return;
				}
				queryData(txtPartNo.getText().toString(), "up",
						String.valueOf(cc));
			}
		});
		btnDown.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// exit without type anything
				if (txtPartNo.getText().toString() == "") {
					return;
				}
				queryData(txtPartNo.getText().toString(), "down",
						String.valueOf(cc));
			}
		});
		btnCounts.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showRecordCountsDialog(v);
			}
		});

		elementsData = new ArrayList<TreeElement>();
		elements = new ArrayList<TreeElement>();
		element0 = new ArrayList<TreeElement>();
		element1 = new ArrayList<TreeElement>();
		treeViewAdapter = new TreeViewAdapter(getActivity(), elements,
				elementsData);
		treeview.setAdapter(treeViewAdapter);
		treeview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				// 點擊的item代表的元素
				TreeElement element = (TreeElement) treeViewAdapter
						.getItem(position);
				treeViewAdapter.setSelectedPosition(position);
				ArrayList<TreeElement> elements = treeViewAdapter.getElements();
				// 元素的資料
				ArrayList<TreeElement> elementsData = treeViewAdapter
						.getElementsData();
				showPartData(element);
				// 點擊没有子项的item直接返回
				// if (!element.isHasChildren()) {
				// treeViewAdapter.notifyDataSetChanged();
				// return;
				// }
				/*
				 * if (element.isExpanded()) { element.setExpanded(false); //
				 * 删除節點内部對應子節點數據，包括子節點的子節點... ArrayList<TreeElement>
				 * elementsToDel = new ArrayList<TreeElement>(); for (int i =
				 * position + 1; i < elements.size(); i++) { if
				 * (element.getLevel() >= elements.get(i).getLevel()) break;
				 * elementsToDel.add(elements.get(i)); }
				 * elements.removeAll(elementsToDel);
				 * treeViewAdapter.notifyDataSetChanged(); } else {
				 * element.setExpanded(true); //
				 * 從資料中提取子節點數據添加進樹，注意这里只是添加了下一级子節點，為了簡化邏輯 int i = 1;//
				 * 注意这里的計數器放在for外面才能保證計數有效 for (TreeElement e : elementsData) {
				 * if ((element.getId()).equals(e.getParendId())) {
				 * e.setExpanded(false); elements.add(position + i, e); i++; } }
				 * treeViewAdapter.notifyDataSetChanged(); }
				 */
			}
		});
	}

	// Function H
	private void hideActionBar() {
		ActionBar mActionBar = getActivity().getActionBar();
		if (mActionBar.isShowing()) {
			mActionBar.hide();
		}

	}

	// Function L
	@Override
	public void loadData(Object result) {

		try {
			JSONObject jsonObject = new JSONObject((String) result);
			if (jsonObject.getString("success").equals("true")
					&& jsonObject.getJSONArray("data") != null) {
			
				JSONArray data = jsonObject.getJSONArray("data");
				element0.clear();
				element1.clear();
				elements.clear();
				elementsData.clear();
				boolean hasChildren = false;
				int parentId = 0;
				int lastlevel = 0;
				JSONObject item, item2;
				String name = "";
                if(data.length()==1){
                	item = data.getJSONObject(0);
                	name = item.getString("PartNo") + ";"
							+ item.getString("PartsName") + ";"
							+ item.getString("Unit") + ";"
							+ item.getString("Qty") + ";"
							+ item.getString("Spec") + ";"
							+ item.getString("Material") + ";"
							+ item.getString("InStock");
                	element = new TreeElement(
							name,
							0,
							"",
							"0",
							TreeElement.NO_PARENT + "",
							false,
							 false);
                	element0.add(element);
					elements.addAll(element0);
					elementsData.addAll(element0);
	                treeViewAdapter.notifyDataSetChanged();
                	return ;
                }				
				for (int i = 0; i < data.length(); i++) {
					item = data.getJSONObject(i);
					int level = Integer.valueOf(item.getString("Level"));
					name = item.getString("PartNo") + ";"
							+ item.getString("PartsName") + ";"
							+ item.getString("Unit") + ";"
							+ item.getString("Qty") + ";"
							+ item.getString("Spec") + ";"
							+ item.getString("Material") + ";"
							+ item.getString("InStock");
					if (i == data.length() - 1) {
						for (int j = parentlist.size() - 1; j >= 0; j--) {
							parentId = parentlist.get(j);
							item2 = data.getJSONObject(parentId);
							lastlevel = Integer.valueOf(item2
									.getString("Level"));
							if (level > lastlevel) {
								break;

							} else if (item2 != null && lastlevel >= level) {
								parentlist.remove(j);
							}
						}
						parentId = parentlist.get(parentlist.size() - 1);
						element = new TreeElement(
								name,
								Integer.valueOf(item.getString("Level")),
								"",
								String.valueOf(i),
								String.valueOf(parentId),
								false,
								false);
						if(Integer.valueOf(item.getString("Level"))>0)
						 element1.add(element);						
						else {
						 element0.add(element);	
						}
						break;
					} else {
						item2 = data.getJSONObject(i + 1);
					}
					if (item2 != null
							&& level < Integer
									.valueOf(item2.getString("Level"))) {
						hasChildren = true;
					} else {
						hasChildren = false;

					}


					if (level == 0) {
						parentlist.clear();
						element = new TreeElement(
								name,
								Integer.valueOf(item.getString("Level")),
								"",
								String.valueOf(i),
								TreeElement.NO_PARENT + "",
								hasChildren,
								((hasChildren == true && action.equals("down")) ? true
										: false));
						element0.add(element);
						// elementsData.add(element);
						parentId = i;
						parentlist.add(parentId);

					} else if (level == 1) {
						for (int j = parentlist.size() - 1; j >= 0; j--) {
							parentId = parentlist.get(j);
							item2 = data.getJSONObject(parentId);
							lastlevel = Integer.valueOf(item2
									.getString("Level"));
							if (level > lastlevel) {
								break;

							} else if (item2 != null && lastlevel >= level) {
								parentlist.remove(j);
							}
						}
						element = new TreeElement(
								name,
								Integer.valueOf(item.getString("Level")),
								"",
								String.valueOf(i),
								String.valueOf(parentId),
								hasChildren,
								((hasChildren == true && action.equals("down")) ? true
										: false));
						element1.add(element);
						// elementsData.add(element);
						// lastLevel = Integer.valueOf(item.getString("Level"));
						parentId = i;
						parentlist.add(parentId);
						treeViewAdapter.notifyDataSetChanged();
					} else if (Integer.valueOf(item.getString("Level")) > 1
							&& Integer.valueOf(item.getString("Level")) < 7) {
						for (int j = parentlist.size() - 1; j >= 0; j--) {
							parentId = parentlist.get(j);
							item2 = data.getJSONObject(parentId);
							lastlevel = Integer.valueOf(item2
									.getString("Level"));
							if (level > lastlevel) {
								break;
							} else if (item2 != null && lastlevel >= level) {
								parentlist.remove(j);
							}
							treeViewAdapter.notifyDataSetChanged();
						}
						element = new TreeElement(
								name,
								level,
								"",
								String.valueOf(i),
								String.valueOf(parentId),
								hasChildren,
								((hasChildren == true && action.equals("down")) ? true
										: false));
						element1.add(element);
						parentId = i;
						parentlist.add(parentId);

					} else {
						element = new TreeElement(
								name,
								Integer.valueOf(item.getString("Level")),
								"",
								String.valueOf(i),
								String.valueOf(parentId),
								hasChildren,
								(hasChildren == true && action.equals("down")) ? true
										: false);
						elementsData.add(element);
					}

				}
				// element0.addAll(element1);
				if (action.equals("down")) {
					elements.addAll(element0);
					elements.addAll(element1);
					elementsData.addAll(element0);
					elementsData.addAll(element1);
				} else {
					elements.addAll(element0);
					// elements.addAll(element1);
					elementsData.addAll(element0);
					elementsData.addAll(element1);
				}

			}
			treeViewAdapter.notifyDataSetChanged();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Function O
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return initView(inflater, container);
	}

	// Function Q
	private void queryData(String partNo, String method, String count) {

		String url = super.getWebServiceUrl() + "queryBOM";
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		action = method;
		try {

			data.accumulate("PartNo", partNo);
			data.accumulate("ExpandMethod", method);
			data.accumulate("ExpandNum", count);
			jsonObject.accumulate("userid", super.getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988bomquery999");
			jsonObject.accumulate("data", data);
			// url,jsonObjet會顯示Loading icon
			super.postRequest(url, jsonObject);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Funciton S
	private void showPartData(TreeElement element) {
		Bundle b = new Bundle();
		if(this.fragmentManager==null){
			this.fragmentManager=getFragmentManager();
			
		}
		String[] items = element.getContentText().split(";");
		b.putString("partno", items[0].toString());
		b.putString("partname", items[1].toString());
		b.putString("unit", items[2].toString());
		b.putString("qty", items[3].toString());
		b.putString("spec", items[4].toString());
		b.putString("material", items[5].toString());
		b.putString("instock", items[6].toString());
		PartsDataActivity activity = new PartsDataActivity();
		activity.parent = this;
		activity.setArguments(b);
		activity.setFragmentManager(getFragmentManager());
		this.fragmentManager.beginTransaction().hide(this).commit();
		this.fragmentManager.beginTransaction()
				.add(R.id.content_frame, activity, "partsdata").commit();
		this.fragmentManager.beginTransaction().addToBackStack(null);
		this.fragmentManager.beginTransaction().show(activity).commit();

	}

	public void showActionBar() {
		ActionBar mActionBar = getActivity().getActionBar();
		if (mActionBar.isShowing() == false) {
			mActionBar.show();
		}

	}

	public void showRecordCountsDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Record Count").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
				switch (which) {
				case 1:
					cc = 30;
					break;
				case 2:
					cc = 50;
					break;
				default:
					cc = 10;
				}
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
				d.dismiss();
				d = null;
			}
		};
		String[] mString = { "10", "30", "50" };

		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {
						switch (which) {
						case 1:
							cc = 30;
							break;
						case 2:
							cc = 50;
							break;
						default:
							cc = 10;
						}
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

}