package sc.dinero.webfunds.talisman.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_new_plan.*
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.adapters.CategoryAdapter
import sc.dinero.webfunds.talisman.model.ChamaPlan
import sc.dinero.webfunds.talisman.viewmodel.PlanViewModel

class NewPlanActivity : BaseGroupActivity() {

    private lateinit var viewModel : PlanViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_plan)
        viewModel = ViewModelProviders.of(this).get(PlanViewModel::class.java)

        viewModel.getAllCategories().observe(this, Observer {
            spinnerCategory.adapter = CategoryAdapter(NewPlanActivity@this, 0, it)
        })
        buttonActionCreatePlan.setOnClickListener {
            val plan = ChamaPlan()
            plan.amountPerMember = fieldAmount.text.toString().toDouble()
            plan.categoryId  = spinnerCategory.selectedItemId.toInt()
            plan.groupId = getGroup().groupId!!
            viewModel.createPlan(plan).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(
                            {_ -> finish()},
                            {_ -> Toast.makeText(NewPlanActivity@this, "Cannot create plan", Toast.LENGTH_LONG).show()}
                    )
        }
    }
}
