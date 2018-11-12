package sc.dinero.webfunds.talisman.activities

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_manage_group.*
import sc.dinero.webfunds.talisman.R
import sc.dinero.webfunds.talisman.databinding.ActivityManageGroupBinding
import sc.dinero.webfunds.talisman.adapters.LocationAdapter
import sc.dinero.webfunds.talisman.adapters.SectorAdapter
import sc.dinero.webfunds.talisman.model.ChamaGroup
import sc.dinero.webfunds.talisman.model.ChamaLocation
import sc.dinero.webfunds.talisman.model.ChamaSector
import sc.dinero.webfunds.talisman.model.repository.GroupRepositoryImpl
import sc.dinero.webfunds.talisman.viewmodel.GroupViewModel

class ManageGroupActivity : BaseMemberActivity() {

    companion object {
        val MANAGE_MEMBER_REQUEST_CODE = 1000
    }

    private lateinit var binding: ActivityManageGroupBinding
    lateinit var repository : GroupRepositoryImpl

    private lateinit var viewModel : GroupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(GroupViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage_group)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        viewModel.getLocations().observe(this, Observer<List<ChamaLocation>> {
            locationSpinner.adapter = LocationAdapter(baseContext, android.R.layout.simple_spinner_item, it)
        })

        viewModel.getSectors().observe(this, Observer<List<ChamaSector>> {
            sectorSpinner.adapter = SectorAdapter(baseContext, android.R.layout.simple_spinner_item, it)
        })

        binding.actionButtonCreateGroup.setOnClickListener {
            val group = ChamaGroup(null,
                    binding.fieldGroupName.text.toString(),
                    binding.locationSpinner.selectedItemId!!.toInt(),
                    binding.sectorSpinner.selectedItemId!!.toInt(),
                    binding.fieldDescription.text.toString())
            viewModel.createGroup(group, getCurrentMember().memberId!!).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe (
                            {_ ->
                                setResult(Activity.RESULT_OK)
                                finish()
                            },
                            { error ->
                                Toast.makeText(applicationContext, "The group exists with this name", Toast.LENGTH_LONG). show()
                                error.printStackTrace()
                            }
                    )
        }

    }

}
