<?php


namespace SlimBundle\Form;
use SlimBundle\Entity\Produit;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;

use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\DateType;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Bundle\FrameworkBundle\Tests\Fixtures\Validation\Category;
use Symfony\Component\Form\FormTypeInterface;
class CatalogueType extends AbstractType
{
    /**
     * {@inheritdoc}
     */

    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('nom',EntityType::class,
            array('class'=>'SlimBundle:Produit',
                'choice_label'=>'nomproduit',))
            ->add('saison', ChoiceType::class,array('choices'=>array('Ete'=>'Ete',
                'Automne'=>'Automne',
                'Hiver'=>'Hiver',
                'Printemps'=>'Printemps',)))

        ->add('datedebut', DateType::class, [
            'widget' => 'choice',
        ])->add('datefin', DateType::class, [
            'widget' => 'choice',
        ])->add("Confirmer",SubmitType::class);
    }/**
 * {@inheritdoc}
 */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'SlimBundle\Entity\Catalogue'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'slimbundle_Catalogue';
    }
}