package ebisus.monkagiga.kamicompapp.android.ui.charadetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import ebisus.monkagiga.kamicompapp.R
import ebisus.monkagiga.kamicompapp.core.domain.enums.AbilityColor
import ebisus.monkagiga.kamicompapp.databinding.ListitemCharaDetailsAbilityBinding
import ebisus.monkagiga.kamicompapp.ext.dp

class CharaDetailsAbilityViewHolder(
    private val binding: ListitemCharaDetailsAbilityBinding,
    private val abilityEffectsItemTransformer: AbilityEffectsItemTransformer,
    private val effectOutcomeItemTransformer: EffectOutcomeItemTransformer
) : RecyclerView.ViewHolder(binding.root) {

    constructor(
        parent: ViewGroup,
        abilityEffectsItemTransformer: AbilityEffectsItemTransformer,
        effectOutcomeItemTransformer: EffectOutcomeItemTransformer
    ) : this(
        ListitemCharaDetailsAbilityBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        abilityEffectsItemTransformer,
        effectOutcomeItemTransformer
    )

    fun bind(item: CharaDetailsItem.Ability) {

        val adapter = AbilityEffectAdapter(
            effectItemFactory = {
                AbilityEffectViewHolder(
                    it,
                    effectOutcomeItemTransformer
                )
            }
        )
        binding.abilityEffectList.adapter = adapter
        binding.abilityEffectList.layoutManager = LinearLayoutManager(itemView.context, RecyclerView.VERTICAL, false)
        adapter.items = abilityEffectsItemTransformer.transform(item.ability)

        binding.frame.setImageResource(
            when (item.ability.ability.abilityColor) {
                AbilityColor.RED -> R.drawable.red_frame
                AbilityColor.GREEN -> R.drawable.green_frame
                AbilityColor.BLUE -> R.drawable.blue_frame
                AbilityColor.YELLOW -> R.drawable.yellow_frame
            }
        )

        binding.abilityTitle.text = item.ability.ability.name
        binding.cooldownTextView.text = item.ability.ability.cooldownTurns.toString()

        val drawable = CircularProgressDrawable(itemView.context)
        drawable.strokeWidth = 4.dp.toFloat()
        drawable.centerRadius = 24.dp.toFloat()
        @Suppress("DEPRECATION")
        drawable.setColorSchemeColors(ContextCompat.getColor(itemView.context, R.color.colorAccentPressed))
        drawable.start()
        Glide.with(binding.image)
            .load(item.abilityIconUrl)
            .placeholder(drawable)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.image)
    }
}
