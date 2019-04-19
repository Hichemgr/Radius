<?php


namespace SlimBundle\Repository;
use Doctrine\ORM\EntityRepository;

use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass="SlimBundle\Repository\LivraisonRepository")
 */

class LivraisonRepository extends EntityRepository
{

    public function AffecterLivreur($idLivraison,$nomLivreur)
    {
        $this->getEntityManager()->createQuery("UPDATE SlimBundle:Livraison l SET l.nomLivreur = $nomLivreur, l.etat = 1 WHERE l.idLivraison = $idLivraison");
    }
}