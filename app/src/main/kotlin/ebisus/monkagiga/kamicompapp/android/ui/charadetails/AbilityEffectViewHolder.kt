package ebisus.monkagiga.kamicompapp.android.ui.charadetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ebisus.monkagiga.kamicompapp.databinding.ListItemAbilityEffectBinding

class AbilityEffectViewHolder(
    private val binding: ListItemAbilityEffectBinding,
    private val effectOutcomeItemTransformer: EffectOutcomeItemTransformer
) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup, effectOutcomeItemTransformer: EffectOutcomeItemTransformer) : this(
        ListItemAbilityEffectBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        effectOutcomeItemTransformer
    )

    fun bind(item: AbilityEffectItem) {
        val adapter = EffectOutcomeAdapter(
            outcomeDealsDamageFactory = {
                OutcomeDealsDamageViewHolder(it)
            }
        )
        binding.effectOutcomeList.layoutManager = LinearLayoutManager(itemView.context, RecyclerView.VERTICAL, false)
        binding.effectOutcomeList.adapter = adapter

        adapter.items = effectOutcomeItemTransformer.transform(item.effect)
    }
}
